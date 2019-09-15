import account.*;

public class BankAccountApp {

    public static void main(String[] args) {
        // Checking Account 1
        Account chkAcc1 = new Checking("Sam Smith", "123456789", 1500);

        // Checking Account 2
        Account chkAcc2 = new Checking("Emma Watson", "741852963", 3500);

        // Savings Account 1
        Account savAcc1 = new Savings("John Doe", "975461384", 500);

        // Savings Account 2
        Account savAcc2 = new Savings("Black Mamba", "963852721", 250);

        chkAcc1.showInfo();
        System.out.println();
        chkAcc2.showInfo();
        System.out.print("\n--------------------------------------------\n\n");
        savAcc1.showInfo();
        System.out.println();
        savAcc2.showInfo();
    }
}
