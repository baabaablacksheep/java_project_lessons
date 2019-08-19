package courses.types;

import courses.Course;

import java.io.Serializable;

public class MathCourse extends Course implements Serializable {

    private static volatile MathCourse mathCourseInstance;

    private MathCourse(){
        courseTitle = "Mathematics 101";
        gradeClass = 1;
        courseFee = 600;

        //Prevent form the reflection api.
        if (mathCourseInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }
    public static MathCourse getInstance(){
        if (mathCourseInstance == null) { //if there is no instance available... create new one
            synchronized (MathCourse.class) {
                if (mathCourseInstance == null) mathCourseInstance = new MathCourse();
            }
        }

        return mathCourseInstance;
    }

    //Make singleton from serialize and deserialize operation.
    protected MathCourse readResolve() {
        return getInstance();
    }
}