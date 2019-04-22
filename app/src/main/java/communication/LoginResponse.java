package communication;


public class LoginResponse extends ResponseImpl{

  private String token;
  
  
  public LoginResponse(boolean successful, String token, String message) {
    super(successful, message);
    this.token = token;
  }
  
  
  public LoginResponse() {
    super();
    this.token = "";
  }
  public void setToken(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }
  
  
  
  
}
