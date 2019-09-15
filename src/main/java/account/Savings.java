package account;

public class Savings extends Account {

    private static int boxCounter = 0;
    private String safetyDepBoxNo;
    private String depBoxAccessCode;
    public Savings(String accountHolderName, String socialSecNum, double initDeposit) {
        super(accountHolderName, socialSecNum, initDeposit);
        super.accountNo = "1" + accountNo;
        setupDepositBox();

    }

    private void setupDepositBox(){
        this.safetyDepBoxNo = String.format("%03d",(++boxCounter));
        this.depBoxAccessCode = String.format("%04d",(int)(Math.random() * Math.pow(10,4)));
    }

    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("Account Type: Savings");
        System.out.println("Safety Box Number: "+ this.safetyDepBoxNo);
        System.out.println("PIN: "+ getDepBoxAccessCode());
    }

    private String getDepBoxAccessCode() {
        return depBoxAccessCode;
    }
}
