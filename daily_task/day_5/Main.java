
public class Main {

    public static void main(String[] args) {

        // Runtime polymorphism
        Payment p1 = new CardPayment(1000);
        Payment p2 = new UPIPayment(500);
        Payment p3 = new CashPayment(200);

        p1.pay();
        p2.pay();
        p3.pay();

        // Method overloading
        p1.pay(750, "INR");

        // Interface implementation
        Refundable refundable = new CardPayment(1000);
        refundable.refund(100);
    }
}
