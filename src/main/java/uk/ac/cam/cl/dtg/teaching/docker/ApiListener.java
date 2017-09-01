package uk.ac.cam.cl.dtg.teaching.docker;

public interface ApiListener {

  public void callCompleted(boolean apiAvailable, long timeTaken, String methodName);
}
