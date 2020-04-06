package taibahCS;

import java.util.ArrayList;

public class TAs extends FacultyMember {

    final int MAXMUM_NUMBER_OF_COURSE = 3;
    final int QUOTA_OF_CREDIT_HOURS = 9;
    private ArrayList<String> assigendCourses = null;

    public TAs() {

    }

    public TAs(ArrayList<String> assigendCourses) {
        this.assigendCourses = assigendCourses;
    }

    public TAs(int FacultyID, String firstName, String lastName, String academicRank, String academicSpecialization) {
        super(FacultyID, firstName, lastName, academicRank, academicSpecialization);
    }

    public String toString() {

        return "\nFacultyID : " + this.FacultyID + "\nFirstName : " + this.firstName
                + "\nLastName : " + this.lastName + "\nAcademicRank : " + this.academicRank
                + "\nAcademicSpecialization : " + this.academicSpecialization + "\n";

    }

    public ArrayList<String> getAssigendCourses() {

        return this.assigendCourses;

    }

    public void setAssigendCourses(ArrayList<String> assigendCourses) {
        this.assigendCourses = assigendCourses;
    }

}
