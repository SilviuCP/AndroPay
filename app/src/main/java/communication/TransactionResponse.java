package communication;

public class TransactionResponse extends ResponseImpl {
  
  private double balance;
  
  public TransactionResponse(boolean successful, String token, String message, double balance) {
    super(successful, message);
    this.balance = balance;
  }
  
  public TransactionResponse() {
    super();
    this.balance = 0.0;
  }
  
  public double getBalance() {
    return balance;
  }
  
  public void setBalance(double balance) {
    this.balance = balance;
  }  
  
}
