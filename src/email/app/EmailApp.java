package email.app;

public class EmailApp {

    public static void main(String[] args) {
        Email email_1 = new Email("Kamal","Ranasinghe","AxelLanka", "Sales");
        Email email_2 = new Email("Amal","Gunasekara","ABCompany");

        System.out.println("Email 1 : "+email_1.getEmailAddress());
        System.out.println("Email 2 : "+email_2.getEmailAddress());

        System.out.println("User_1 Name : "+email_1.getName());
        System.out.println("User_2 Name : "+email_2.getName());

    }
}
