package taibahCS;

public class Conveners extends FacultyMember {

    public Conveners() {
    }

    public Conveners(int FacultyID, String firstName, String lastName, String academicRank, String academicSpecialization) {
        super(FacultyID, firstName, lastName, academicRank, academicSpecialization);
    }
public  String toString(){
      
        return
                
       "\nFacultyID : "+this.FacultyID +"\nFirstName : "+this.firstName+
           "\nLastName : "+this.lastName+"\nAcademicRank : "+this.academicRank+
                "\nAcademicSpecialization : "+this.academicSpecialization+"\n";
                
    }
   

}
