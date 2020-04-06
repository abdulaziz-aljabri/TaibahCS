package taibahcs;

import java.util.List;

public class TAs extends FacultyMember {

    public static final int MAXIMUM_NUMBER_OF_COURSE = 3;
     public static final int QUOTA_OF_CREDIT_HOURS = 9;
    private List<String> assignedCourses = null;

    public TAs() {

    }

    public TAs(List<String> assignedCourses) {
        this.assignedCourses = assignedCourses;
    }

    public TAs(int facultyId, String firstName, String lastName, String academicRank, String academicSpecialization) {
        super(facultyId, firstName, lastName, academicRank, academicSpecialization);
    }

    public String toString() {

        return "\nfacultyId : " + this.facultyId + "\nFirstName : " + this.firstName
                + "\nLastName : " + this.lastName + "\nAcademicRank : " + this.academicRank
                + "\nAcademicSpecialization : " + this.academicSpecialization + "\n";

    }

    public List<String> getAssignedCourses() {
        return assignedCourses;
    }

    public void setAssignedCourses(List<String> assignedCourses) {
        this.assignedCourses = assignedCourses;
    }
}
