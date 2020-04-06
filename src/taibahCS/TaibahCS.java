package taibahCS;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;

public class TaibahCS {

    static Scanner in = new Scanner(System.in);
    static TaibahCS taibahCSObj = new TaibahCS();

    public static void main(String[] args) {

        ArrayList<TAs> TAsList = new ArrayList<TAs>();
        TAs TA = null;

        ArrayList<Lecturers> lecturerList = new ArrayList<Lecturers>();
        Lecturers lecturer = null;

        ArrayList<Course> courseList = new ArrayList<Course>();
        Course course = null;

        System.out.println(" #### Welcom to TaibahuCS #### ");
        System.out.println(" #### Type  1- Adding TA member.  2- Adding Lectures member.  3- Adding course.  4- Operation.   5- Exit #### ");
        int operation = in.nextInt();
        in.nextLine(); // Consuming the leftover new line, using the nextLine() method to solve the problem.

        System.out.println("");

        while (operation != 5) {
            switch (operation) {
                case 1:
                    System.out.println(" #### Please enter all information about TA member  #### ");
                    System.out.println("");
                    TA = new TAs();
                    System.out.print(" Enter the TA's ID : ");
                    TA.setFacultyID(in.nextInt());
                    System.out.print(" Enter the  TA's First Name : ");
                    TA.setFirstName(in.next());
                    System.out.print(" Enter the  TA's Last Name : ");
                    TA.setLastName(in.next());
                    in.nextLine(); // Consuming the leftover new line, using the nextLine() method to solve the problem.
                    System.out.print(" Enter the  TA's Academic Rank :");
                    TA.setAcademicRank(in.nextLine());
                    System.out.print(" Enter the  TA's Academic Specialization : ");
                    TA.setAcademicSpecialization(in.nextLine());
                    TA.setAssigendCourses(new ArrayList<>());
                    TAsList.add(TA);
                    System.out.println("");
                    System.out.println("The member data has been added successfully.");
                    System.out.println(TAsList.get(TAsList.size() - 1).toString());
                    break;
                case 2:
                    System.out.println(" #### Please enter all information about Lecturer member  #### ");
                    System.out.println("");
                    lecturer = new Lecturers();
                    System.out.print(" Enter the Lecturer's ID : ");
                    lecturer.setFacultyID(in.nextInt());
                    System.out.print(" Enter the  Lecturer's First Name : ");
                    lecturer.setFirstName(in.next());
                    System.out.print(" Enter the  Lecturer's Last Name : ");
                    lecturer.setLastName(in.next());
                    in.nextLine(); // Consuming the leftover new line, using the nextLine() method to solve the problem.
                    System.out.print(" Enter the  Lecturer's Academic Rank :");
                    lecturer.setAcademicRank(in.nextLine());
                    System.out.print(" Enter the  Lecturer's Academic Specialization : ");
                    lecturer.setAcademicSpecialization(in.nextLine());
                    lecturer.setAssigendCourses(new ArrayList<>());

                    lecturerList.add(lecturer);
                    System.out.println("");
                    System.out.println("The member data has been added successfully.");
                    System.out.println(lecturerList.get(lecturerList.size() - 1).toString());
                    break;
                case 3:
                    System.out.println(" #### Please enter all information about course  #### ");
                    System.out.println("");
                    course = new Course();
                    System.out.print(" Enter the course's Code : ");
                    course.setCourseCode(in.nextLine());
                    System.out.print(" Enter the course's Name : ");
                    course.setCourseName(in.nextLine());
                    System.out.print(" Enter the  course's Hours : ");
                    course.setCreditHours(in.nextInt());
                    in.nextLine(); // Consuming the leftover new line, using the nextLine() method to solve the problem.
                    courseList.add(course);
                    System.out.println("");
                    System.out.println("The course has been added successfully.");
                    System.out.println(courseList.get(courseList.size() - 1).toString());
                    break;
                case 4:
                    System.out.println("Choose the operation by typing the number.");
                    System.out.println("1- Assign course to TA member. \n 2- Assign course to Lecturer member.  \n 3- Drop course from TA member. \n 4- Drop course from Lecturer member. \n 5- Display the faculty members information. \n 6- comprehensive report");
                    int supOperation = in.nextInt();
                    in.nextLine(); // Consuming the leftover new line, using the nextLine() method to solve the problem.

                    switch (supOperation) {
                        case 1:
                            System.out.println("These are the courses list you have added in the system.");
                            System.out.println("taibahCS.Course Code --- taibahCS.Course Name  --- Credit Hours");
                            for (int index = 0; index < courseList.size(); index++) {
                                System.out.println(courseList.get(index).getCourseCode() + " " + courseList.get(index).getCourseName() + " " + courseList.get(index).getCreditHours());
                            }
                            System.out.println("Enter the course code : ");
                            String courseCode = in.nextLine();
                            System.out.println("Faculty ID --- Faculty Full Name");
                            for (int index = 0; index < TAsList.size(); index++) {
                                System.out.println(TAsList.get(index).getFacultyID() + " " + TAsList.get(index).getFullName());
                            }
                            System.out.println("Enter the faculty ID to assign the course to him/her : ");
                            int facultyID = in.nextInt();
                            try {
                                taibahCSObj.allocateCourseTA(taibahCSObj.getTAByFacultyID(TAsList, facultyID), taibahCSObj.getCourseByCourseCode(courseList, courseCode), courseList);

                                System.out.println("The course has been assigned to TA member successfully.");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;
                        case 2:
                            System.out.println("These are the courses list you have added in the system.");
                            System.out.println("taibahCS.Course Code --- taibahCS.Course Name  --- Credit Hours");
                            for (int index = 0; index < courseList.size(); index++) {
                                System.out.println(courseList.get(index).getCourseCode() + " " + courseList.get(index).getCourseName() + " " + courseList.get(index).getCreditHours());
                            }
                            System.out.println("Enter the course code : ");
                            courseCode = in.nextLine();
                            System.out.println("Faculty ID --- Faculty Full Name");
                            for (int index = 0; index < lecturerList.size(); index++) {
                                System.out.println(lecturerList.get(index).getFacultyID() + " " + lecturerList.get(index).getFullName());
                            }
                            System.out.println("Enter the faculty ID to assign the course to him/her : ");
                            facultyID = in.nextInt();
                            try {
                                taibahCSObj.allocateCourseLecturer(taibahCSObj.getLecturerByFacultyID(lecturerList, facultyID), taibahCSObj.getCourseByCourseCode(courseList, courseCode), courseList);
                                System.out.println("The course has been assigned to Lecturer member successfully.");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;
                        case 3:
                            System.out.println("These are the courses list you have added in the system.");
                            System.out.println("taibahCS.Course Code --- taibahCS.Course Name  --- Credit Hours");
                            for (int index = 0; index < courseList.size(); index++) {
                                System.out.println(courseList.get(index).getCourseCode() + " " + courseList.get(index).getCourseName() + " " + courseList.get(index).getCreditHours());
                            }
                            System.out.println("Enter the course code : ");
                            courseCode = in.nextLine();
                            System.out.println("Faculty ID --- Faculty Full Name");
                            for (int index = 0; index < TAsList.size(); index++) {
                                System.out.println(TAsList.get(index).getFacultyID() + " " + TAsList.get(index).getFullName());
                            }
                            System.out.println("Enter the faculty ID to drop the course from him/her : ");
                            facultyID = in.nextInt();
                            try {
                                taibahCSObj.dropCourseForTA(taibahCSObj.getTAByFacultyID(TAsList, facultyID), taibahCSObj.getCourseByCourseCode(courseList, courseCode));
                                System.out.println("The course has been dropped from TA member successfully.");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;
                        case 4:
                            System.out.println("These are the courses list you have added in the system.");
                            System.out.println("taibahCS.Course Code --- taibahCS.Course Name  --- Credit Hours");
                            for (int index = 0; index < courseList.size(); index++) {
                                System.out.println(courseList.get(index).getCourseCode() + " " + courseList.get(index).getCourseName() + " " + courseList.get(index).getCreditHours());
                            }
                            System.out.println("Enter the course code : ");
                            courseCode = in.nextLine();
                            System.out.println("Faculty ID --- Faculty Full Name");
                            for (int index = 0; index < lecturerList.size(); index++) {
                                System.out.println(lecturerList.get(index).getFacultyID() + " " + lecturerList.get(index).getFullName());
                            }
                            System.out.println("Enter the faculty ID to drop the course from him/her : ");
                            facultyID = in.nextInt();
                            try {
                                taibahCSObj.dropCourseForLecturer(taibahCSObj.getLecturerByFacultyID(lecturerList, facultyID), taibahCSObj.getCourseByCourseCode(courseList, courseCode));
                                System.out.println("The course has been dropped from Lecturer member successfully.");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;
                        case 5:
                            taibahCSObj.printFacultyMembersDetails(TAsList, lecturerList, courseList);
                            break;
                        case 6:
                            taibahCSObj.comprehensiveReport(TAsList, lecturerList, courseList);
                            break;

                    }

                    break;
                case 5:
                    exit(0);
                    break;
                default:
                    System.out.println("Wrong input!!");
                    break;
            }

            System.out.println(" #### Type  1- Adding TA member.  2- Adding Lectures member.  3- Adding course.  4- Operation.   5- Exit #### ");
            operation = in.nextInt();
            in.nextLine(); // Consuming the leftover new line, using the nextLine() method to solve the problem.

        }

        System.out.println("");
        System.out.println(" #### Thank you to use our application (TaibahuCS) #### ");
        System.out.println(" #### End. ####");

    }

    public void dropCourseForTA(TAs facultyObject, Course course) throws Exception {
        if (facultyObject.getAssigendCourses() == null) {
            throw new Exception(" This faculty member have not any assignd course yet!! ");

        } else {
            facultyObject.getAssigendCourses().remove(course.getCourseCode());

        }
    }

    public void allocateCourseTA(TAs facultyObject, Course course, ArrayList<Course> courseList) throws Exception {

        if (facultyObject.getAssigendCourses().size() < facultyObject.MAXMUM_NUMBER_OF_COURSE) {
            facultyObject.getAssigendCourses().add(course.getCourseCode());
            course.setIsSigned(true);
            updateCourseList(courseList, course);

        } else {
            throw new Exception("This faculty member is exceeded his maximum number of courses.");

        }
    }

    public void allocateCourseLecturer(Lecturers facultyObject, Course course, ArrayList<Course> courseList) throws Exception {

        if (facultyObject.getAssigendCourses().size() < facultyObject.MAXMUM_NUMBER_OF_COURSE) {
            facultyObject.getAssigendCourses().add(course.getCourseCode());
            course.setIsSigned(true);
            updateCourseList(courseList, course);

        } else {
            throw new Exception("This faculty member is exceeded his maximum number of courses.");

        }

    }

    public void dropCourseForLecturer(Lecturers facultyObject, Course course) throws Exception {
        if (facultyObject.getAssigendCourses() == null) {
            throw new Exception(" This faculty member have not any assignd course yet!! ");

        } else {
            facultyObject.getAssigendCourses().remove(course.getCourseCode());

        }
    }

    public boolean isThisTAAbleToTakeThisCourse(TAs TAsList, Course courseObj, ArrayList<Course> courseList) {

        int totalHours = 0;
        for (int index = 0; index < courseList.size(); index++) {
            for (int index2 = 0; index2 < TAsList.getAssigendCourses().size(); index2++) {
                if (TAsList.getAssigendCourses().get(index2).equalsIgnoreCase(courseList.get(index).getCourseCode())) {
                    totalHours += courseList.get(index).getCreditHours();
                }
            }
        }

        if (totalHours > TAsList.QUOTA_OF_CREDIT_HOURS) {
            return false;
        } else {
            return true;
        }

    }

    public boolean isThisLecturerAbleToTakeThisCourse(Lecturers lecturerObj, Course courseObj, ArrayList<Course> courseList) {
        int totalHours = 0;
        for (int index = 0; index < courseList.size(); index++) {
            for (int index2 = 0; index2 < lecturerObj.getAssigendCourses().size(); index2++) {
                if (lecturerObj.getAssigendCourses().get(index2).equalsIgnoreCase(courseList.get(index).getCourseCode())) {
                    totalHours += courseList.get(index).getCreditHours();
                }

            }

        }

        if (totalHours > lecturerObj.QUOTA_OF_CREDIT_HOURS) {
            return false;
        } else {
            return true;
        }
    }

    public String findCourseInfoByCourseCode(String courseCode, ArrayList<Course> courseList) {

        String courseName = null;
        int creditHours = 0;

        for (int index = 0; index < courseList.size(); index++) {
            if (courseList.get(index).getCourseCode().equalsIgnoreCase(courseCode)) {

                courseName = courseList.get(index).getCourseName();
                creditHours = courseList.get(index).getCreditHours();

            }
        }

        return "course code :" + courseCode + " ||  " + "course name :" + courseName + " ||  " + "credit hours :" + creditHours;
    }

    public void printFacultyMembersDetails(ArrayList<TAs> TAsList, ArrayList<Lecturers> lecturer, ArrayList<Course> courseList) {

        for (int index = 0; index < TAsList.size(); index++) {
            System.out.println("\nFacultyID : " + TAsList.get(index).getFacultyID() + "\nFull Name : " + TAsList.get(index).getFullName()
                    + "\nAcademicRank : " + TAsList.get(index).getAcademicRank()
                    + "\nAcademicSpecialization : " + TAsList.get(index).getAcademicSpecialization() + "\n Courses:  ");

            for (int courseIndex = 0; courseIndex < TAsList.get(index).getAssigendCourses().size(); courseIndex++) {
                System.out.println(findCourseInfoByCourseCode(TAsList.get(index).getAssigendCourses().get(courseIndex), courseList));
            }
        }
        for (int index = 0; index < lecturer.size(); index++) {
            System.out.println("\nFacultyID : " + lecturer.get(index).getFacultyID() + "\nFull Name : " + lecturer.get(index).getFullName()
                    + "\nAcademicRank : " + lecturer.get(index).getAcademicRank()
                    + "\nAcademicSpecialization : " + lecturer.get(index).getAcademicSpecialization() + "\n Courses:  ");

            for (int courseIndex = 0; courseIndex < lecturer.get(index).getAssigendCourses().size(); courseIndex++) {
                System.out.println(findCourseInfoByCourseCode(lecturer.get(index).getAssigendCourses().get(courseIndex), courseList));
            }

        }
    }

    public TAs getTAByFacultyID(ArrayList<TAs> TAsList, int facultyID) {
        TAs ta = new TAs();

        for (int index = 0; index < TAsList.size(); index++) {
            if (TAsList.get(index).getFacultyID() == facultyID) {
                ta.setFacultyID(facultyID);
                ta.setFirstName(TAsList.get(index).getFirstName());
                ta.setLastName(TAsList.get(index).getLastName());
                ta.setAcademicRank(TAsList.get(index).getAcademicRank());
                ta.setAcademicSpecialization(TAsList.get(index).getAcademicSpecialization());
                ta.setAssigendCourses(TAsList.get(index).getAssigendCourses());

            }
        }

        return ta;
    }

    public Lecturers getLecturerByFacultyID(ArrayList<Lecturers> lecturerList, int facultyID) {
        Lecturers lecturer = new Lecturers();

        for (int index = 0; index < lecturerList.size(); index++) {
            if (lecturerList.get(index).getFacultyID() == facultyID) {
                lecturer.setFacultyID(facultyID);
                lecturer.setFirstName(lecturerList.get(index).getFirstName());
                lecturer.setLastName(lecturerList.get(index).getLastName());
                lecturer.setAcademicRank(lecturerList.get(index).getAcademicRank());
                lecturer.setAcademicSpecialization(lecturerList.get(index).getAcademicSpecialization());
                lecturer.setAssigendCourses(lecturerList.get(index).getAssigendCourses());

            }
        }

        return lecturer;
    }

    public Course getCourseByCourseCode(ArrayList<Course> courseList, String courseCode) {
        Course course = new Course();

        for (int index = 0; index < courseList.size(); index++) {
            if (courseList.get(index).getCourseCode().equalsIgnoreCase(courseCode)) {
                course.setCourseCode(courseCode);
                course.setCourseName(courseList.get(index).getCourseName());
                course.setCreditHours(courseList.get(index).getCreditHours());

            }
        }

        return course;
    }

    public void comprehensiveReport(ArrayList<TAs> TAsList, ArrayList<Lecturers> lecturer, ArrayList<Course> course) {
        taibahCSObj.printFacultyMembersDetails(TAsList, lecturer, course);
        taibahCSObj.printUnallocatedCourseList(course);
    }

    public void printUnallocatedCourseList(ArrayList<Course> course) {
        System.out.println("These are the unllocated courses you have added in the system.");
        System.out.println("taibahCS.Course Code --- taibahCS.Course Name  --- Credit Hours");

        if (course.isEmpty()) {
            System.out.println(" There is no  course in the system");

        } else {

            for (int index = 0; index < course.size(); index++) {
                System.out.println("");
                if (!course.get(index).isIsSigned()) {
                    System.out.println(course.get(index).getCourseCode() + " " + course.get(index).getCourseName() + " " + course.get(index).getCreditHours());
                }

            }
        }
    }

    public void updateCourseList(ArrayList<Course> courseList, Course course) {
        for (int index = 0; index < courseList.size(); index++) {
            if (courseList.get(index).getCourseCode().equalsIgnoreCase(course.getCourseCode())) {
                courseList.set(index, course);
            }
        }
    }

}
