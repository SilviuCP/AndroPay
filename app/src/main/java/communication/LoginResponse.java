package communication;


public class LoginResponse extends ResponseImpl{

  private String token;
  private double balance;
  
  
  public LoginResponse(boolean successful, String token, double balance,String message) {
    super(successful, message);
    this.token = token;
    this.balance = balance;
  }
  
  public LoginResponse() {
    super();
    this.token = "";
    this.balance = 0.0;
  }
  public void setToken(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public double getBalance() {
    return balance;
  }

  
  public void setBalance(double balance) {
    this.balance = balance;
  }
  
  
  
  
}
