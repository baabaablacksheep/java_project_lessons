package email.app;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

class Email {

    // TODO Get User Input to Choose The Department Through a Scanner, Change UserName Only When Creating The Email, Generate The Password Through a Given Set Of Chars

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

    // Creating A Random Object To Generate Random Objects
    private Random rand = new Random();

    // Multiple Constructors to Handle Different Object Initializations
    Email(@NotNull String firstName, @NotNull String lastName, @NotNull String company){
        this(firstName,lastName,company,"");
    }
    Email(@NotNull String firstName, @NotNull String lastName, @NotNull String company, String department){
        this.firstName = firstName.toLowerCase();
        this.lastName = lastName.toLowerCase();
        this.company = company.toLowerCase();
        this.department = department.toLowerCase();

        this.emailAddress = generateEmailAddress();
        this.password = generatePassword();
    }

    // Setters
    public void setPassword(String oldPassword, String Newpassword) throws Exception{
        if(this.password.equals(oldPassword)){
            this.password = Newpassword;
        } else {
            throw new IllegalArgumentException("The Provided Password Doesn't Match With The Existing Password");
        }
    }
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Getters
    String getEmailAddress() {
        return emailAddress;
    }
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }
    String getName(){
        String fName_let1 = String.valueOf(firstName.charAt(0)).toUpperCase();
        String lName_let1 = String.valueOf(lastName.charAt(0)).toUpperCase();
        return fName_let1+firstName.substring(1)+" "+lName_let1+lastName.substring(1);
    }

    // Methods Implementing Business Logic
    private String generateEmailAddress(){
        return this.firstName+"."+this.lastName+"@"+(!this.department.equals("") ? this.department +"." : "")+this.company+".com";
    }
    private String generatePassword(){

        // Password Related
        int passwordLength = 10;
        int pwStartChar = 48;
        int pwEndChar = 127;

        StringBuilder strBuilder = new StringBuilder();
        for(int i=0; i<passwordLength; i++){
            int charNum = rand.nextInt(pwEndChar - pwStartChar) + pwStartChar;
            strBuilder.append((char)charNum);
        }
        System.out.println("Password : "+strBuilder.toString());
        return strBuilder.toString();
    }
}
