package levels;

import com.sun.istack.internal.NotNull;
import courses.Course;
import courses.GetCourseFactory;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Scanner;


public class Level1 implements Level, Serializable {

    private int levelNo = 1;
    private static int studentID = 10000;

    private Scanner sc = new Scanner(System.in);

    private static volatile Level1 Level1Instance;
    private GetCourseFactory gcf = new GetCourseFactory();

    private Level1() {

        //Prevent form the reflection api.
        if (Level1Instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static Level1 getInstance() {
        if (Level1Instance == null) { //if there is no instance available... create new one
            synchronized (Level1.class) {
                if (Level1Instance == null) Level1Instance = new Level1();
            }
        }

        return Level1Instance;
    }

    public int generateStudentID() {
        studentID += 1;
        return studentID;
    }

    @Override
    public HashSet<Course> addCourses() {
        HashSet<Course> courses = new HashSet<>();
        addCourseLoop:
        while (true) {
            System.out.print("1 - History 101\n" +
                    "2 - Mathematics 101\n" +
                    "3 - English 101\n" +
                    "4 - Computer Science 101\n" +
                    "5 - To End\n");
            System.out.print("Enter The Course Number: ");
            int courseNo = sc.nextInt();

            switch (courseNo) {
                case 1:
                    courses.add(addCourse("History", courses));
                    break;
                case 2:
                    courses.add(addCourse("Mathematics", courses));
                    break;
                case 3:
                    courses.add(addCourse("English", courses));
                    break;
                case 4:
                    courses.add(addCourse("Computer Science", courses));
                    break;
                case 5:
                    System.out.println("Adding Courses Finished");
                    break addCourseLoop;
                default:
                    System.out.println("Please Enter A Valid Number! \n Enter 6 to Finish Adding Courses...");
            }
        }
        courses.remove(null);
        return courses;
    }

    private Course addCourse(String courseName, @NotNull HashSet<Course> courses) {
        Course newCourse = gcf.getCourse(courseName);
        newCourse.setGradeClass(1);
        if (!courses.contains(newCourse)) {
            System.out.println("Student Successfully Enrolled in the " + courseName + " Course!");
            return newCourse;
        }
        return null;
    }

    //Make singleton from serialize and deserialize operation.
    protected Level1 readResolve () {
        return getInstance();
    }

}
