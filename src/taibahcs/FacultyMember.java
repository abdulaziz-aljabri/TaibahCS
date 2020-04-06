package taibahcs;

public class FacultyMember {

    protected int facultyId;
    protected String academicRank;
    protected String academicSpecialization;
    protected String firstName;
    protected String lastName;

    public FacultyMember() {

    }

    public FacultyMember(int facultyId, String firstName, String lastName, String academicRank, String academicSpecialization) {

        this.facultyId = facultyId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.academicRank = academicRank;
        this.academicSpecialization = academicSpecialization;

    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public void setAcademicRank(String academicRank) {
        this.academicRank = academicRank;
    }

    public void setAcademicSpecialization(String academicSpecialization) {
        this.academicSpecialization = academicSpecialization;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public String getAcademicRank() {
        return academicRank;
    }

    public String getAcademicSpecialization() {
        return academicSpecialization;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getFullName()
    {
        return this.firstName + " " + this.lastName;
    }
    public  String toString(){
      
        return
                
       "\nFacultyID : "+this.facultyId +"\nFirstName : "+this.firstName+
           "\nLastName : "+this.lastName+"\nAcademicRank : "+this.academicRank+
                "\nAcademicSpecialization : "+this.academicSpecialization+"\n";
                
    }
    

}
