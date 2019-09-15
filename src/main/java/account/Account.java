package account;

import main.api.IBaseRate;
import org.jetbrains.annotations.NotNull;

public abstract class Account implements IBaseRate {

    // Common Fields
    private String accountHolderName;
    private String socialSecurityNo;
    private double accountBalance;

    String accountNo;
    private static int accountIndex = 10000;

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
    }

    // Common Methods
    @NotNull
    private String setAccNum(){
        String last2DigitsOfSsn = this.socialSecurityNo.substring(socialSecurityNo.length()-2);
        String randomNum = String.format("%.3f", Math.random()).substring(2);
        return last2DigitsOfSsn+(++accountIndex)+randomNum;
    }
    void deposit(){

    }
    void withdraw(){

    }
    void trasnfer() {

    }
}
