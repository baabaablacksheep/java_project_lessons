package studentdatabaseapp;

import student.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Number of Students To Be Registered: ");
        int numStudents = sc.nextInt();

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < numStudents; i++) {
            Student stud = new Student();
            students.add(stud);
        }

        System.out.println("--- Manually Manipulating Student1 ---");
        Student[] studentsArr = students.toArray(new Student[students.size()]);
        System.out.println(studentsArr[0].getTotalTuitionFee());
        studentsArr[0].payTutionFees();
        System.out.println(studentsArr[0].getBalance());
        studentsArr[0].showInfo();

    }
}
