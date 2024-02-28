public class Account {
    protected String name;
    protected String numPhone;
    protected double factMoney;


    public double getFactMoney() {
        return factMoney;
    }

    public void setFactMoney(double factMoney) throws InsufficientFundsException {
        if (factMoney>=0) {
            this.factMoney = factMoney;
        }
        else {
            throw new InsufficientFundsException("Недостаточно денег на счету", factMoney);
        }
    }


    protected Account(String name, String numPhone, double factMoney) {
        this.name = name;
        this.numPhone = numPhone;
        this.factMoney = factMoney;
    }
    public static Account create(String name, String numPhone, double factMoney) throws NumPhoneExeption, IllegalArgumentException {
        if (!checkNum(numPhone))
        {
            throw new NumPhoneExeption("Не корректный ввод номера телефона", numPhone);
        }
        if (factMoney<0)
        {
            throw new IllegalArgumentException("Отрицательный счет", factMoney);
        }
        return new Account(name, numPhone, factMoney);
    }
    public static boolean checkNum(String num)
    {
        try {
            Long.parseLong(num);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public void makeTransfer(double transfer, Account transferAcc) throws InsufficientFundsException {
        try {
            this.setFactMoney(this.getFactMoney() - transfer);
            transferAcc.setFactMoney(transferAcc.getFactMoney() + transfer);
        }
        catch (InsufficientFundsException e)
        {
            throw new InsufficientFundsException("Невозможен перевод", factMoney);
        }
    }
    public void takeMoney(double count) throws InsufficientFundsException {
        try {
            this.setFactMoney(this.getFactMoney()-count);
        }
        catch (InsufficientFundsException e)
        {
            throw new InsufficientFundsException("Невозможно снятие наличных", factMoney);
        }
    }

}
