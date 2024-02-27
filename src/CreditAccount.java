public class CreditAccount extends Account {
    private double credit;

    private CreditAccount(String name, String numPhone, double factMoney, double credit) {
        super(name, numPhone, factMoney);
        this.credit = credit;
    }

    public static CreditAccount create(String name, String numPhone, double factMoney, double credit) {

        return new CreditAccount(name, numPhone, factMoney, credit);
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void takeCredit(double count)
    {
        this.setCredit(this.getCredit()-count);
    }
    public void addCredit(double count)
    {
        this.setFactMoney(this.getFactMoney()-count);
        this.setCredit(this.getCredit()+count);
    }
}