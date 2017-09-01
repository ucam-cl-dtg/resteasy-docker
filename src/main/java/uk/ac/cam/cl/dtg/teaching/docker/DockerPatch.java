package uk.ac.cam.cl.dtg.teaching.docker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.cam.cl.dtg.teaching.docker.api.DockerApi;

public class DockerPatch {

  private static final String DOCKER_AUFS_ERROR_PREFIX = "Driver aufs failed to remove";
  private static final String DOCKER_DEVICE_MAPPER_ERROR_PREFIX =
      "Driver devicemapper failed to remove";

  private static final Logger log = LoggerFactory.getLogger(DockerPatch.class);

  public static void deleteContainer(DockerApi api, String id, Boolean force, Boolean removeVolumes)
      throws APIUnavailableException {
    for (int retry = 1; retry <= 5; ++retry) {
      try {
        api.deleteContainer(id, force, removeVolumes);
        return;
      } catch (RuntimeException e) {
        if (e.getMessage().contains(DOCKER_AUFS_ERROR_PREFIX)
            || e.getMessage().contains(DOCKER_DEVICE_MAPPER_ERROR_PREFIX)) {
          log.info("Retry {} of 5: Caught driver error when deleting container {}", retry, id);
          removeContainerMounts(id);
        } else if (e.getMessage().startsWith("No such container: " + id)) {
          // sometimes the delete succeeds even if it says it didn't
          return;
        } else {
          throw e;
        }
      }
    }
  }

  private static void removeContainerMounts(String containerID) {
    // A map sorted by longest string first.  This means when we umount we will remove over-mounts
    // first
    Set<String> mountPoints =
        new TreeSet<String>(
            new Comparator<String>() {
              @Override
              public int compare(String o1, String o2) {
                int l1 = o1.length();
                int l2 = o2.length();
                if (l1 > l2) return -1;
                if (l1 < l2) return 1;
                return o1.compareTo(o2);
              }
            });
    try (BufferedReader r = new BufferedReader(new FileReader("/proc/mounts"))) {
      String line;
      while ((line = r.readLine()) != null) {
        String[] fields = line.split(" ");
        String mountPoint = fields[1];
        if (mountPoint.contains(containerID)) {
          mountPoints.add(mountPoint);
        }
      }
    } catch (IOException e) {
      log.error("IOException reading mounts for container " + containerID, e);
      return;
    }

    if (mountPoints.size() > 0) {
      log.info("Removing {} stale mountpoints for {}", mountPoints.size(), containerID);
      for (String mountPoint : mountPoints) {
        ProcessBuilder b = new ProcessBuilder("sudo", "/bin/umount", mountPoint);
        try {
          Process p = b.start();
          p.waitFor();
        } catch (IOException e) {
          log.error("IOException unmounting device", e);
        } catch (InterruptedException e) {
          log.error("Interrupted exception waiting for process", e);
        }
      }
    }
  }
}
