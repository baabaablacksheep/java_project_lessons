package courses.types;

import courses.Course;
import java.io.Serializable;

public class ChemistryCourse extends Course implements Serializable {

    private static volatile ChemistryCourse chemistryCourseInstance;

    private ChemistryCourse(){
        courseTitle = "Chemistry 101";
        gradeClass = 1;
        courseFee = 600;

        //Prevent form the reflection api.
        if (chemistryCourseInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }
    public static ChemistryCourse getInstance() {
        if (chemistryCourseInstance == null) { //if there is no instance available... create new one
            synchronized (ChemistryCourse.class) {
                if (chemistryCourseInstance == null) chemistryCourseInstance = new ChemistryCourse();
            }
        }

        return chemistryCourseInstance;
    }

    //Make singleton from serialize and deserialize operation.
    protected ChemistryCourse readResolve() {
        return getInstance();
    }
}