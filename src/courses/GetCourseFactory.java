package courses;

import courses.types.*;

public class GetCourseFactory{

    //use getCourse method to get object of type Plan
    public Course getCourse(String planType){
        switch(planType.toUpperCase()){
            case "ENGLISH": return EnglishCourse.getInstance();
            case "MATHEMATICS": return MathCourse.getInstance();
            case "HISTORY": return HistoryCourse.getInstance();
            case "CHEMISTRY": return ChemistryCourse.getInstance();
            case "COMPUTER SCIENCE": return CSCourse.getInstance();
            default: return null;
        }
    }
}
