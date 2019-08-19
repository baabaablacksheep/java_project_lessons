package levels;

import courses.Course;
import java.util.HashSet;

public interface Level {
    int generateStudentID();
    HashSet<Course> addCourses();

}
