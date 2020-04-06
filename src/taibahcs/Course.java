package taibahcs;

public class Course {

    private String courseCode;
    private String courseName;
    private int creditHours;
    private boolean isSigned;

    public Course() {

    }

    public Course(String courseCode, String courseName, int creditHours) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }


    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }

    public String toString() {

        return

                "\nCourseCode : " + this.courseCode + "\nCourseName : " + this.courseName +
                        "\nCreditHours : " + this.creditHours + "\n";

    }

}
