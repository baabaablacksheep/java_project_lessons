package courses.types;

import courses.Course;

import java.io.Serializable;

public class HistoryCourse extends Course implements Serializable {

    private static volatile HistoryCourse historyCourseInstance;

    private HistoryCourse(){
        courseTitle = "History 101";
        gradeClass = 1;
        courseFee = 600;

        //Prevent form the reflection api.
        if (historyCourseInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }
    public static HistoryCourse getInstance() {
        if (historyCourseInstance == null) { //if there is no instance available... create new one
            synchronized (HistoryCourse.class) {
                if (historyCourseInstance == null) historyCourseInstance = new HistoryCourse();
            }
        }

        return historyCourseInstance;
    }

    //Make singleton from serialize and deserialize operation.
    protected HistoryCourse readResolve() {
        return getInstance();
    }
}