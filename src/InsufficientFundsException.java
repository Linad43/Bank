public class InsufficientFundsException extends BankException {

    public InsufficientFundsException(String message, double money) {
        super(message, money);
    }
}
