package courses;

public abstract class Course {

    protected String courseTitle;

    protected int gradeClass;
    protected double courseFee;

    public void setGradeClass(int gradeClass) {
        this.gradeClass = gradeClass;
    }
    public String getCourseTiltle(){
        return courseTitle;
    }
    public double getCourseFee(){
        return courseFee;
    }
    public double getgradeClass(){
        return gradeClass;
    }
}