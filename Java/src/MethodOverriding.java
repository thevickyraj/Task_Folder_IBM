
class Payment{
    void pay(){
        System.out.println("Processing Payment.....");
    }
}
class CreditCard extends Payment{
    void pay(){
        System.out.println("PAyment done using credit card");
    }
}
class UPI extends Payment{
    void pay(){
        System.out.println("Payment done using UPI");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        Payment payment;
        payment = new UPI();
        payment.pay();
        payment = new CreditCard();
        payment.pay();
    }
}
