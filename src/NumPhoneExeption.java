public class NumPhoneExeption extends Exception{

    public String numPhone;
    public NumPhoneExeption(String message, String numPhone) {
        super(message);
        this.numPhone = numPhone;
    }
}
