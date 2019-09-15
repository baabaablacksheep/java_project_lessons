package account;

import api.IBaseRate;
import org.jetbrains.annotations.NotNull;

public abstract class Account implements IBaseRate {

    // Common Fields
    private String accountHolderName;
    private String socialSecurityNo;
    private double accountBalance;

    String accountNo;
    private static int accountIndex = 10000;

    double rate;

    Account(String accountHolderName, String socialSecNum, double initDeposit) {
        this.accountHolderName = accountHolderName;
        this.socialSecurityNo = socialSecNum;
        this.accountBalance = initDeposit;
        this.accountNo = setAccNum();
    }

    public void showInfo(){
        System.out.println("Account Number: "+ this.accountNo);
        System.out.println("Account Holder Name: "+ accountHolderName);
        System.out.println("Account Balance: "+ accountBalance);
        System.out.println("Interest Rate: "+ rate);
    }

    // Common Methods
    @NotNull
    private String setAccNum(){
        String last2DigitsOfSsn = this.socialSecurityNo.substring(socialSecurityNo.length()-2);
        String randomNum = String.format("%.3f", Math.random()).substring(2);
        return last2DigitsOfSsn+(++accountIndex)+randomNum;
    }

    abstract void setRate();

    // Methods For Transactions
    public void deposit(double amount){
        accountBalance = accountBalance + amount;
        System.out.println("$"+amount+" has been Credited to your Account");
        printBalance();
    }
    public void withdraw(double amount){
        if(accountBalance - amount < 0){
            System.out.println("Insufficient Funds");
            printBalance();
        }
        else {
            accountBalance = accountBalance - amount;
            System.out.println("$" + amount + " has been Deducted from your Account");
            printBalance();
        }
    }
    public void trasnfer(String toWhere, double amount) {
        withdraw(amount);
        if(accountBalance - amount > 0) {
            System.out.println("$" + amount + " has Been Transferred To " + toWhere);
            printBalance();
        }
    }
    private void printBalance(){
        System.out.println("You Current Balance: "+ accountBalance);
    }
}
