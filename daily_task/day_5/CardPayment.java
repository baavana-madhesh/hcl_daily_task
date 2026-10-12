
public class CardPayment extends Payment implements Refundable {

    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Card payment: Rs. " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund processed: Rs. " + amount);
    }
}
