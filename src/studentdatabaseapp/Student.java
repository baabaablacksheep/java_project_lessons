package studentdatabaseapp;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int year;

    private String studentID;
    private ArrayList[] courses = new ArrayList[0];

    private int tuitionBalance;
    private int costPerCourse = 600;

    Student(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student First Name: ");
        this.firstName = sc.nextLine();
        System.out.print("Enter Student Last Name: ");
        this.lastName = sc.nextLine();
        System.out.print("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\n Choose Student Grade: ");
        this.year = sc.nextInt();
    }

    // TODO Give Student 5-digit unique ID, with the first number being their grade level
    // TODO Add a Method To Keep The Student Count as an Static Variable For each Year
    String generateStudentID(){
        Random rand = new Random();
        return Integer.toString(year) + rand.nextInt(9999);
    }

    // TODO Add Courses To The Student
    //  A student can enroll in the following courses:
    //  History 101
    //  Mathematics 101
    //  English 101
    //  Chemistry 101
    //  Computer Science 101
    void addCourse(String courseName){

    }


    // TODO ADD Cost To Each Student With $600 per each Course

    // TODO Add ShowInfo Method To get Name, ID, Courses Enrolled and Balance
}
