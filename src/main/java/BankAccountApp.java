import account.*;
import util.CsvReader;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {

//        String filePath = "D:\\Projects\\My_Projects\\Java_Advance\\java_project_lessons\\src\\main\\resources\\NewBankAccounts.csv";
        String filePath = "src\\main\\resources\\NewBankAccounts.csv";

        //Read CSV File
        List<String[]> dataList = new CsvReader().read(filePath);
        List<Account> accounts = new LinkedList<>();

        for(String[] dataRow: dataList){
            String accountHolderName = dataRow[0].trim();
            String socialSecurityNum = dataRow[1].trim();
            String accountType = dataRow[2].trim();
            double initDeposit = Double.parseDouble(dataRow[3].trim());

            switch (accountType) {
                case "Savings":
                    accounts.add(new Savings(accountHolderName, socialSecurityNum, initDeposit));
                    break;
                case "Checking":
                    accounts.add(new Checking(accountHolderName, socialSecurityNum, initDeposit));
                    break;
                default:
                    System.out.println("Error Finding Account Type");
                    break;
            }
        }

        Account acc1 = accounts.get(0);
        Account acc2 = accounts.get(4);

        acc1.showInfo();
        acc1.deposit(1000.00);

        System.out.println();

        acc2.showInfo();
        acc2.withdraw(500.00);


//        Account chkAcc1 = new Checking("Sam Smith", "123456789", 1500);
//        Account savAcc1 = new Savings("John Doe", "975461384", 500);
    }
}
