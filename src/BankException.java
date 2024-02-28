public abstract class BankException extends Exception {
    public final double money;


    public BankException(String message, double money) {
        super(message);
        this.money = money;
    }
}
