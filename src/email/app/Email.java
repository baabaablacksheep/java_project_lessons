package email.app;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

class Email {

    // Basic Info of the User
    private String firstName;
    private String lastName;
    private String company;
    private String department;

    // Account Attributes
    private String emailAddress;
    private String password;

    private int mailboxCapacity = 100;
    private String alternateEmail;

    // Multiple Constructors to Handle Different Object Initializations
    Email(@NotNull String firstName, @NotNull String lastName, @NotNull String company){
        this(firstName,lastName,company,"");
    }
    Email(@NotNull String firstName, @NotNull String lastName, @NotNull String company, String department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        if(department.equals("")){
            this.department = departmentSelector();
        } else {
            this.department = department.toLowerCase();
        }
        this.emailAddress = generateEmailAddress();
        this.password = generatePassword();
        System.out.println("Generated Password: "+this.password);
    }

    // Setters
    void setPassword(String oldPassword, String newPassword) throws Exception{
        if(this.password.equals(oldPassword)){
            this.password = newPassword;
        } else {
            throw new IllegalArgumentException("The Provided Password Doesn't Match With The Existing Password");
        }
    }
    void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Getters
    private String getEmailAddress() {
        return emailAddress;
    }
    private int getMailboxCapacity() {
        return mailboxCapacity;
    }

    private String getAlternateEmail() {
        return alternateEmail;
    }

    private String getName(){
        return firstName+" "+lastName;
    }

    // Methods Implementing Business Logic
    private String departmentSelector(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose The Department: \n1 - Sales\n2 - Marketing\n3 - Finance\nEnter Your Choice: ");
        int deptNo = sc.nextInt();
        switch(deptNo){
            case 1: return "sales";
            case 2: return "marketing";
            case 3: return "finance";
            default: return "";
        }
    }
    private String generateEmailAddress(){
        return (this.firstName+"."+this.lastName+"@"+(!this.department.equals("") ? this.department +"." : "")+this.company+".com").toLowerCase();
    }
    private String generatePassword(){

        int passwordLength = 10;
        String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$&abcdefghijklmnopqrstuvwxyz";
        char[] passwordChar = new char[passwordLength];
        Random rand = new Random();

        for(int i=0;i<passwordLength;i++){
            passwordChar[i] = charSet.charAt(rand.nextInt(charSet.length()));
        }
        return new String(passwordChar).trim();
    }
    void showInfo(){
        System.out.println("================="+getName()+"===================");
        System.out.println("Username: "+getName());
        System.out.println("Email Address: "+getEmailAddress());
        System.out.println("Mail Box Capacity: "+getMailboxCapacity());
        System.out.println("Alternate Email: "+getAlternateEmail());
    }
}
