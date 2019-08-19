package courses.types;

import courses.Course;
import java.io.Serializable;

public class CSCourse extends Course implements Serializable {

    private static volatile CSCourse csCourseInstance;

    private CSCourse(){
        courseTitle = "Computer Science 101";
        gradeClass = 1;
        courseFee = 600;

        //Prevent form the reflection api.
        if (csCourseInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }
    public static CSCourse getInstance() {
        if (csCourseInstance == null) { //if there is no instance available... create new one
            synchronized (CSCourse.class) {
                if (csCourseInstance == null) csCourseInstance = new CSCourse();
            }
        }

        return csCourseInstance;
    }

    //Make singleton from serialize and deserialize operation.
    protected CSCourse readResolve() {
        return getInstance();
    }
}