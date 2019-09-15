package account;

public class Checking extends Account {

    int debitCardNo;
    int cardPin;

    public Checking(String accountHolderName, String SocialSecNum, double initDeposit) {
        super(accountHolderName, SocialSecNum, initDeposit);
        this.accountNo = "2" + accountNo;
    }

    public void showInfo(){
        super.showInfo();
        System.out.println("Account Number: "+ this.accountNo);
        System.out.println("Account Type: Checking");
    }
}
