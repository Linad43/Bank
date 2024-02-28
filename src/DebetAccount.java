public class DebetAccount extends Account{
    private double debet;
    private DebetAccount(String name, String numPhone, double factMoney, double debet) {
        super(name, numPhone, factMoney);
        this.debet = debet;
    }
    public DebetAccount create(String name, String numPhone, double factMoney, double debet) throws NumPhoneExeption, IllegalArgumentException {
        if (!checkNum(numPhone))
        {
            throw new NumPhoneExeption("Не корректный ввод номера телефона", numPhone);
        }
        if (factMoney<0)
        {
            throw new IllegalArgumentException("Отрицательный счет", factMoney);
        }
        if (debet<0)
        {
            throw new IllegalArgumentException("Отрицательный счет", debet);
        }
        return new DebetAccount(name, numPhone, factMoney, debet);
    }

    public double getDebet() {
        return debet;
    }

    public void setDebet(double debet) throws InsufficientFundsException {
        if (debet>=0) {
            this.debet = debet;
        }
        else {
            throw new InsufficientFundsException("Недостаточно денег на счету", debet);
        }
    }
    public void takeDebet(double count) throws InsufficientFundsException {
        try {
            this.setDebet(this.getDebet() - count);
            this.setFactMoney(this.getFactMoney() + count);
        }
        catch (InsufficientFundsException e)
        {
            throw new InsufficientFundsException("Невозможно перевести из депозита", debet);
        }
    }
    public void addDebet(double count) throws InsufficientFundsException {
        try {
            this.setFactMoney(this.getFactMoney() - count);
            this.setDebet(this.getDebet() + count);
        }
        catch (InsufficientFundsException e)
        {
            throw new InsufficientFundsException("Невозможно пополнить депозит", factMoney);
        }
    }
}
