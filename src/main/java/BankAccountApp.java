import account.*;

public class BankAccountApp {

    public static void main(String[] args) {
        // Checking Account
        Account chkAcc1 = new Checking("Sam Smith", "123456789", 1500);

        // Savings Account
        Account savAcc1 = new Savings("John Doe", "975461345", 500);

        chkAcc1.showInfo();
        System.out.println();
        savAcc1.showInfo();
    }
}
