package uk.ac.cam.cl.dtg.teaching.docker;

public class ApiUnavailableException extends Exception {

  private static final long serialVersionUID = 1L;

  public ApiUnavailableException() {}

  public ApiUnavailableException(String message) {
    super(message);
  }

  public ApiUnavailableException(Throwable cause) {
    super(cause);
  }

  public ApiUnavailableException(String message, Throwable cause) {
    super(message, cause);
  }

  public ApiUnavailableException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
