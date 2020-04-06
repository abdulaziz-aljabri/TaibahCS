package taibahcs;

public class Conveners extends FacultyMember {

    public Conveners() {
    }

    public Conveners(int facultyId, String firstName, String lastName, String academicRank, String academicSpecialization) {
        super(facultyId, firstName, lastName, academicRank, academicSpecialization);
    }
public  String toString(){
      
        return
                
       "\nFacultyID : "+this.facultyId +"\nFirstName : "+this.firstName+
           "\nLastName : "+this.lastName+"\nAcademicRank : "+this.academicRank+
                "\nAcademicSpecialization : "+this.academicSpecialization+"\n";
                
    }
   

}
