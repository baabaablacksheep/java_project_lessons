package account;

public class Checking extends Account {

    private String debitCardNo;
    private static long debitIndex = 100000000000L;
    private String cardPin;

    public Checking(String accountHolderName, String SocialSecNum, double initDeposit) {
        super(accountHolderName, SocialSecNum, initDeposit);
        super.accountNo = "2" + accountNo;
        setupDebitCard();
    }

    private void setupDebitCard(){
        this.debitCardNo = Long.toString(++debitIndex);
        this.cardPin = String.format("%04d",(int)(Math.random() * Math.pow(10,4)));
    }

    public void showInfo(){
        super.showInfo();
        System.out.println("Account Type: Checking");
        System.out.println("Debit Card Number: "+ this.debitCardNo);
        System.out.println("PIN: "+ getCardPin());
    }

    private String getCardPin() {
        return cardPin;
    }
}
