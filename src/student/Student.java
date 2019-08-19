package student;

import courses.Course;


import java.util.*;
import levels.*;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;

    private int studentID;
    private HashSet<Course> courses;

    private double feesPayed = 0.0;

    private Scanner sc = new Scanner(System.in);

    public Student(){
        System.out.print("Enter Student First Name: ");
        this.firstName = sc.nextLine();
        System.out.print("Enter Student Last Name: ");
        this.lastName = sc.nextLine();
        System.out.print("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nChoose Student Grade: ");
        this.gradeYear = sc.nextInt();

        Level level;
        switch(gradeYear){
            case 1: level = Level1.getInstance(); break;
            case 2: level = Level2.getInstance(); break;
            case 3: level = Level1.getInstance(); break;
            case 4: level = Level2.getInstance(); break;
            default: level = null; break;
        }

        if (level != null) {
            this.studentID = level.generateStudentID();
            this.courses = level.addCourses();
        }
        payTutionFees();
        showInfo();
    }

    public double getTotalTuitionFee(){
        return courses.stream().mapToDouble(Course::getCourseFee).sum();
    }

    public void payTutionFees(){
        System.out.print("Please Enter The Amount Payed: ");
        double amount = sc.nextDouble();
        this.feesPayed += amount;
        System.out.println("Successfully Paid $"+this.feesPayed);
    }

    public double getBalance(){
        return this.feesPayed - getTotalTuitionFee();
    }

    public void showInfo(){
        System.out.println("Student Name: "+firstName+" "+lastName);
        System.out.println("Student Year: "+gradeYear);
        System.out.println("StudentID: "+studentID);
        System.out.print("Courses: "); for(Course c: courses) System.out.print("\n "+c.getCourseTiltle());
        System.out.println("\nTotal Course Fee: "+getTotalTuitionFee());
        System.out.println("Total Amount Paid: "+ this.feesPayed);
        System.out.println("Balance: $ "+ getBalance());
    }
}
