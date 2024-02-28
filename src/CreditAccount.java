public class CreditAccount extends Account {
    private double credit;

    private CreditAccount(String name, String numPhone, double factMoney, double credit) {
        super(name, numPhone, factMoney);
        this.credit = credit;
    }

    public static CreditAccount create(String name, String numPhone, double factMoney, double credit) throws NumPhoneExeption, IllegalArgumentException {
        if (!checkNum(numPhone))
        {
            throw new NumPhoneExeption("Не корректный ввод номера телефона", numPhone);
        }
        if (factMoney<0)
        {
            throw new IllegalArgumentException("Отрицательный счет", factMoney);
        }
        if (credit<0)
        {
            throw new IllegalArgumentException("Отрицательный счет", credit);
        }
        return new CreditAccount(name, numPhone, factMoney, credit);
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) throws InsufficientFundsException {
        if (credit>=0)
        {
            this.credit = credit;
        }
        else
        {
            throw new InsufficientFundsException("Недостаточно денег на счету", credit);
        }
    }

    public void takeCredit(double count) throws InsufficientFundsException {
        try {
            this.setCredit(this.getCredit()-count);
        }
        catch (InsufficientFundsException e)
        {
            throw new InsufficientFundsException("Невозможно снятие наличных", credit);
        }
    }
    public void addCredit(double count) throws InsufficientFundsException {
        try {
            this.setFactMoney(this.getFactMoney()-count);
            this.setCredit(this.getCredit()+count);
        }
        catch (InsufficientFundsException e)
        {
            throw new InsufficientFundsException("Невозможно пополнение кредитки", credit);
        }

    }
}