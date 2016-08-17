package uk.ac.cam.cl.dtg.teaching.docker;

public interface APIListener {

	public void callCompleted(boolean apiAvailable,long timeTaken,String methodName);
	
	
}
