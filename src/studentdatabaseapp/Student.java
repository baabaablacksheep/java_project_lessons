package studentdatabaseapp;

import java.util.*;

class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;

    private String studentID;
    private HashSet<String> courses;

    private int tuitionBalance;
    private int costPerCourse = 600;

    Scanner sc = new Scanner(System.in);

    Student(){
        System.out.print("Enter Student First Name: ");
        this.firstName = sc.nextLine();
        System.out.print("Enter Student Last Name: ");
        this.lastName = sc.nextLine();
        System.out.print("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nChoose Student Grade: ");
        this.gradeYear = sc.nextInt();

        this.studentID = generateStudentID();

        courses = new HashSet<>();
        addCourses();

        showInfo();
    }

    // TODO Give Student 5-digit unique ID, with the first number being their grade level
    // TODO Add a Method To Keep The Student Count as an Static Variable For each Year
    String generateStudentID(){
        Random rand = new Random();
        return Integer.toString(gradeYear) + rand.nextInt(9999);
    }

    void addCourses(){
        while(true){
            System.out.print("Enter The Course Name: ");
            String courseName = sc.next();
            if(courseName.trim().toLowerCase().equals("end")){
                break;
            }
            addCourse(courseName);
        }
    }

    // TODO Add Courses To The Student
    // A student can enroll in the following courses:
    // History 101
    // Mathematics 101
    // English 101
    // Chemistry 101
    // Computer Science 101
    void addCourse(String courseName){
        if(!courses.contains(courseName)){
            boolean isAdded = courses.add(courseName);
            if (isAdded) {
                tuitionBalance += costPerCourse;
            }
        }
    }

    int payTutionFees(int amount){
        this.tuitionBalance-=amount;
        return this.tuitionBalance;
    }

    void showInfo(){
        System.out.println("Student Name: "+firstName+" "+lastName);
        System.out.println("StudentID: "+studentID);
        System.out.print("Courses: "); for(String c: courses) System.out.print(c+", ");
        System.out.println("\b\b\nBalance: $"+tuitionBalance);
    }
}
