public class Bank {
    public static void main(String[] args) throws NumPhoneExeption, IllegalArgumentException {
        try {
            CreditAccount credits1 = CreditAccount.create("Bob", "+79993332222", 12000, 50000);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        try {
            CreditAccount credits2 = CreditAccount.create("Bob", "+79993332222", 12000, -50000);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        try {
            CreditAccount credits3 = CreditAccount.create("Bob", "+79993332222", -12000, 50000);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        try {
            CreditAccount credits4 = CreditAccount.create("Bob", "+799f3332222", 12000, 50000);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}