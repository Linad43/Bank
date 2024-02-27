public class DebetAccount extends Account{
    private double debet;
    private DebetAccount(String name, String numPhone, double factMoney, double debet) {
        super(name, numPhone, factMoney);
        this.debet = debet;
    }
    public DebetAccount create(String name, String numPhone, double factMoney, double debet)
    {
        return new DebetAccount(name, numPhone, factMoney, debet);
    }

    public double getDebet() {
        return debet;
    }

    public void setDebet(double debet) {
        this.debet = debet;
    }
    public void takeDebet(double count)
    {
        this.setDebet(this.getDebet()-count);
        this.setFactMoney(this.getFactMoney()+count);
    }
    public void addDebet(double count)
    {
        this.setFactMoney(this.getFactMoney()-count);
        this.setDebet(this.getDebet()+count);
    }
}
