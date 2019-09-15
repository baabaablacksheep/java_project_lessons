package account;

public class Savings extends Account {

    static int boxCounter = 1;
    String safetyDepBoxNo;
    String depBoxAccessCode;
    public Savings(String accountHolderName, String socialSecNum, double initDeposit) {
        super(accountHolderName, socialSecNum, initDeposit);
        this.accountNo = "1" + accountNo;
        safetyDepBoxNo = "" + ++boxCounter;

    }

    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("Account Number: "+ this.accountNo);
        System.out.println("Account Type: Savings");
    }

}
