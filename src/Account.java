public class Account {
    protected String name;
    protected String numPhone;
    protected double factMoney;


    public double getFactMoney() {
        return factMoney;
    }

    public void setFactMoney(double factMoney) {
        this.factMoney = factMoney;
    }


    protected Account(String name, String numPhone, double factMoney) {
        this.name = name;
        this.numPhone = numPhone;
        this.factMoney = factMoney;
    }
    public static Account create(String name, String numPhone, double factMoney)
    {
        return new Account(name, numPhone, factMoney);
    }


    public void makeTransfer(double transfer, Account transferAcc)
    {
        this.setFactMoney(this.getFactMoney()-transfer);
        transferAcc.setFactMoney(transferAcc.getFactMoney()+transfer);
    }
    public void takeMoney(double count)
    {
        this.setFactMoney(this.getFactMoney()-count);
    }


}
