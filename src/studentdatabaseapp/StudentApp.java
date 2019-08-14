package studentdatabaseapp;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Number of Students To Be Registered: ");
        int numStudents = sc.nextInt();

        for (int i = 0; i < numStudents; i++) {
            Student stud = new Student();
            students.add(stud);
        }

        for (Student student : students) {
            int newBalance = student.payTutionFees(200);
            System.out.println("New Balance: "+ newBalance);
        }
    }
}
