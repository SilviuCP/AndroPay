package communication;

public class ResponseImpl implements Response {
  
  private String message;
  private boolean successful;
  
  public ResponseImpl(boolean successful, String message) {
    this.successful = successful;
    this.message = message;
  }
  
  public ResponseImpl(){
    this.successful = false;
    this.message  = "";
  }
  
  
  public void setMessage(String message) {
    this.message = message;
  }

  
  public void setSuccessful(boolean successful) {
    this.successful = successful;
  }

  @Override
  public boolean getSuccessful() {
    return successful;
  }
  
  @Override
  public String getMessage() {
    return message;
  }
  
}
