package levels;

import com.sun.istack.internal.NotNull;
import courses.Course;
import courses.GetCourseFactory;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Scanner;


public class Level2 implements Level, Serializable {

    private int levelNo = 1;
    private static int studentID = 10000;

    private Scanner sc = new Scanner(System.in);

    private static volatile Level2 Level2Instance;
    private GetCourseFactory gcf = new GetCourseFactory();

    private Level2() {

        //Prevent form the reflection api.
        if (Level2Instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static Level2 getInstance() {
        if (Level2Instance == null) { //if there is no instance available... create new one
            synchronized (Level2.class) {
                if (Level2Instance == null) Level2Instance = new Level2();
            }
        }

        return Level2Instance;
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
            System.out.print("1 - History 201\n" +
                    "2 - Mathematics 201\n" +
                    "3 - English 201\n" +
                    "4 - Chemistry 201\n" +
                    "5 - Computer Science 201\n" +
                    "6 - To End\n");
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
                    courses.add(addCourse("Chemistry", courses));
                    break;
                case 5:
                    courses.add(addCourse("Computer Science", courses));
                    break;
                case 6:
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
        newCourse.setGradeClass(2);
        if (!courses.contains(newCourse)) {
            System.out.println("Student Successfully Enrolled in the " + courseName + " Course!");
            return newCourse;
        }
        return null;
    }

    //Make singleton from serialize and deserialize operation.
    protected Level2 readResolve () {
        return getInstance();
    }

}
