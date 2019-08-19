package courses.types;

import courses.Course;
import java.io.Serializable;

public class EnglishCourse extends Course implements Serializable {

    private static volatile EnglishCourse englishCourseInstance;

    private EnglishCourse(){
        courseTitle = "English 101";
        gradeClass = 1;
        courseFee = 600;

        //Prevent form the reflection api.
        if (englishCourseInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }
    public static EnglishCourse getInstance() {
        if (englishCourseInstance == null) { //if there is no instance available... create new one
            synchronized (EnglishCourse.class) {
                if (englishCourseInstance == null) englishCourseInstance = new EnglishCourse();
            }
        }

        return englishCourseInstance;
    }

    //Make singleton from serialize and deserialize operation.
    protected EnglishCourse readResolve() {
        return getInstance();
    }
}