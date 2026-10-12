
public abstract class Payment {

    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    // Abstract method: child classes must implement it
    public abstract void pay();

    // Overloaded method: different parameter list
    public void pay(double amount, String currency) {
        System.out.println("Payment amount: " + currency + " " + amount);
    }
}
