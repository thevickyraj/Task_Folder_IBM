public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accnumber, double balance){
        this.accountNumber = accnumber;
        this.balance = balance;
    }

    public void withdraw(double amount){
        if(amount > balance){
            throw  new IllegalArgumentException("Insufficient Balance");
        }
        balance -= amount;
    }
    public double getBalance() {
        return balance;
    }

}
