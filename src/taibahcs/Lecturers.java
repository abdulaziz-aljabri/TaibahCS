package taibahcs;

import java.util.List;

public class Lecturers extends FacultyMember {

    public static final int MAXIMUM_NUMBER_OF_COURSE = 3;
    public static final int QUOTA_OF_CREDIT_HOURS = 12;
    private List<String> assignedCourses = null;

    public Lecturers() {

    }

    public Lecturers(List<String> assignedCourses) {
        this.assignedCourses = assignedCourses;
    }

    public Lecturers(int facultyId, String firstName, String lastName, String academicRank, String academicSpecialization) {
        super(facultyId, firstName, lastName, academicRank, academicSpecialization);
    }

    public List<String> getAssignedCourses() {
        return assignedCourses;
    }

    public void setAssignedCourses(List<String> assignedCourses) {
        this.assignedCourses = assignedCourses;
    }

    public String toString() {

        return "\nFacultyID : " + this.facultyId + "\nFirstName : " + this.firstName
                + "\nLastName : " + this.lastName + "\nAcademicRank : " + this.academicRank
                + "\nAcademicSpecialization : " + this.academicSpecialization + "\n";

    }


}
