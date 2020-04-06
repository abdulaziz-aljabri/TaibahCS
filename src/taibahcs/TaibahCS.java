package taibahcs;

import static java.lang.System.exit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaibahCS {

    static Scanner in = new Scanner(System.in);
    static TaibahCS taibahCSObj = new TaibahCS();
    static final String COURSE_LIST_MSG = "These are the courses list you have added in the system.";
    static final String COURSE_LIST_HEADER = "Course Code --- Course Name  --- Credit Hours";
    static final String ENTER_COURSE_CODE_MSG = "Enter the course code : ";
    static final String FACULTY_LIST_HEADER = "Faculty ID --- Faculty Full Name";


    public static void main(String[] args) {

        List<TAs> tasList = new ArrayList<>();
        TAs ta = null;

        List<Lecturers> lecturerList = new ArrayList<>();
        Lecturers lecturer = null;

        List<Course> courseList = new ArrayList<>();
        Course course = null;

        System.out.println(" #### Welcom to TaibahuCS #### ");
        System.out.println(" #### Type  1- Adding ta member.  2- Adding Lectures member.  3- Adding course.  4- Operation.   5- Exit #### ");
        int operation = in.nextInt();
        in.nextLine(); // Consuming the leftover new line, using the nextLine() method to solve the problem.

        System.out.println("");

        while (operation != 5) {
            switch (operation) {
                case 1:
                    System.out.println(" #### Please enter all information about ta member  #### ");
                    System.out.println("");
                    ta = new TAs();
                    System.out.print(" Enter the ta's ID : ");
                    ta.setFacultyId(in.nextInt());
                    System.out.print(" Enter the  ta's First Name : ");
                    ta.setFirstName(in.next());
                    System.out.print(" Enter the  ta's Last Name : ");
                    ta.setLastName(in.next());
                    in.nextLine(); // Consuming the leftover new line, using the nextLine() method to solve the problem.
                    System.out.print(" Enter the  ta's Academic Rank :");
                    ta.setAcademicRank(in.nextLine());
                    System.out.print(" Enter the  ta's Academic Specialization : ");
                    ta.setAcademicSpecialization(in.nextLine());
                    ta.setAssignedCourses(new ArrayList<>());
                    tasList.add(ta);
                    System.out.println("");
                    System.out.println("The member data has been added successfully.");
                    System.out.println(tasList.get(tasList.size() - 1).toString());
                    break;
                case 2:
                    System.out.println(" #### Please enter all information about Lecturer member  #### ");
                    System.out.println("");
                    lecturer = new Lecturers();
                    System.out.print(" Enter the Lecturer's ID : ");
                    lecturer.setFacultyId(in.nextInt());
                    System.out.print(" Enter the  Lecturer's First Name : ");
                    lecturer.setFirstName(in.next());
                    System.out.print(" Enter the  Lecturer's Last Name : ");
                    lecturer.setLastName(in.next());
                    in.nextLine(); // Consuming the leftover new line, using the nextLine() method to solve the problem.
                    System.out.print(" Enter the  Lecturer's Academic Rank :");
                    lecturer.setAcademicRank(in.nextLine());
                    System.out.print(" Enter the  Lecturer's Academic Specialization : ");
                    lecturer.setAcademicSpecialization(in.nextLine());
                    lecturer.setAssignedCourses(new ArrayList<>());

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
                    System.out.println("1- Assign course to ta member. \n 2- Assign course to Lecturer member.  \n 3- Drop course from ta member. \n 4- Drop course from Lecturer member. \n 5- Display the faculty members information. \n 6- comprehensive report");
                    int supOperation = in.nextInt();
                    in.nextLine(); // Consuming the leftover new line, using the nextLine() method to solve the problem.

                    switch (supOperation) {
                        case 1:
                            System.out.println(COURSE_LIST_MSG);
                            System.out.println(COURSE_LIST_HEADER);
                            for (int index = 0; index < courseList.size(); index++) {
                                System.out.println(courseList.get(index).getCourseCode() + " " + courseList.get(index).getCourseName() + " " + courseList.get(index).getCreditHours());
                            }
                            System.out.print(ENTER_COURSE_CODE_MSG);
                            String courseCode = in.nextLine();
                            System.out.println(FACULTY_LIST_HEADER);
                            for (int index = 0; index < tasList.size(); index++) {
                                System.out.println(tasList.get(index).getFacultyId() + " " + tasList.get(index).getFullName());
                            }
                            System.out.print("Enter the faculty ID to assign the course to him/her : ");
                            int facultyID = in.nextInt();
                            try {
                                taibahCSObj.allocateCourseTA(taibahCSObj.getTAByFacultyID(tasList, facultyID), taibahCSObj.getCourseByCourseCode(courseList, courseCode), courseList);

                                System.out.println("The course has been assigned to ta member successfully.");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;
                        case 2:
                            System.out.println(COURSE_LIST_MSG);
                            System.out.println(COURSE_LIST_HEADER);
                            for (int index = 0; index < courseList.size(); index++) {
                                System.out.println(courseList.get(index).getCourseCode() + " " + courseList.get(index).getCourseName() + " " + courseList.get(index).getCreditHours());
                            }
                            System.out.print(ENTER_COURSE_CODE_MSG);
                            courseCode = in.nextLine();
                            System.out.println(FACULTY_LIST_HEADER);
                            for (int index = 0; index < lecturerList.size(); index++) {
                                System.out.println(lecturerList.get(index).getFacultyId() + " " + lecturerList.get(index).getFullName());
                            }
                            System.out.print("Enter the faculty ID to assign the course to him/her : ");
                            facultyID = in.nextInt();
                            try {
                                taibahCSObj.allocateCourseLecturer(taibahCSObj.getLecturerByFacultyID(lecturerList, facultyID), taibahCSObj.getCourseByCourseCode(courseList, courseCode), courseList);
                                System.out.println("The course has been assigned to Lecturer member successfully.");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;
                        case 3:
                            System.out.println(COURSE_LIST_MSG);
                            System.out.println(COURSE_LIST_HEADER);
                            for (int index = 0; index < courseList.size(); index++) {
                                System.out.println(courseList.get(index).getCourseCode() + " " + courseList.get(index).getCourseName() + " " + courseList.get(index).getCreditHours());
                            }
                            System.out.print(ENTER_COURSE_CODE_MSG);
                            courseCode = in.nextLine();
                            System.out.println(FACULTY_LIST_HEADER);
                            for (int index = 0; index < tasList.size(); index++) {
                                System.out.println(tasList.get(index).getFacultyId() + " " + tasList.get(index).getFullName());
                            }
                            System.out.print("Enter the faculty ID to drop the course from him/her : ");
                            facultyID = in.nextInt();
                            try {
                                taibahCSObj.dropCourseForTA(taibahCSObj.getTAByFacultyID(tasList, facultyID), taibahCSObj.getCourseByCourseCode(courseList, courseCode));
                                System.out.println("The course has been dropped from ta member successfully.");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;
                        case 4:
                            System.out.println(COURSE_LIST_MSG);
                            System.out.println(COURSE_LIST_HEADER);
                            for (int index = 0; index < courseList.size(); index++) {
                                System.out.println(courseList.get(index).getCourseCode() + " " + courseList.get(index).getCourseName() + " " + courseList.get(index).getCreditHours());
                            }
                            System.out.print(ENTER_COURSE_CODE_MSG);
                            courseCode = in.nextLine();
                            System.out.println(FACULTY_LIST_HEADER);
                            for (int index = 0; index < lecturerList.size(); index++) {
                                System.out.println(lecturerList.get(index).getFacultyId() + " " + lecturerList.get(index).getFullName());
                            }
                            System.out.print("Enter the faculty ID to drop the course from him/her : ");
                            facultyID = in.nextInt();
                            try {
                                taibahCSObj.dropCourseForLecturer(taibahCSObj.getLecturerByFacultyID(lecturerList, facultyID), taibahCSObj.getCourseByCourseCode(courseList, courseCode));
                                System.out.println("The course has been dropped from Lecturer member successfully.");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;
                        case 5:
                            taibahCSObj.printFacultyMembersDetails(tasList, lecturerList, courseList);
                            break;
                        case 6:
                            taibahCSObj.comprehensiveReport(tasList, lecturerList, courseList);
                            break;
                        default:
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

            System.out.println(" #### Type  1- Adding ta member.  2- Adding Lectures member.  3- Adding course.  4- Operation.   5- Exit #### ");
            operation = in.nextInt();
            in.nextLine(); // Consuming the leftover new line, using the nextLine() method to solve the problem.

        }

        System.out.println("");
        System.out.println(" #### Thank you to use our application (TaibahuCS) #### ");
        System.out.println(" #### End. ####");

    }

    public void dropCourseForTA(TAs facultyObject, Course course) {
        if (facultyObject.getAssignedCourses() == null) {
            try {
                throw new IllegalArgumentException(" This faculty member have not any assigned course yet!! ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            facultyObject.getAssignedCourses().remove(course.getCourseCode());

        }
    }

    public void allocateCourseTA(TAs facultyObject, Course course, List courseList) {

        if (facultyObject.getAssignedCourses().size() < facultyObject.MAXIMUM_NUMBER_OF_COURSE) {
            facultyObject.getAssignedCourses().add(course.getCourseCode());
            course.setSigned(true);
            updateCourseList(courseList, course);

        } else {
            try {
                throw new IllegalArgumentException("This faculty member is exceeded his maximum number of courses.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void allocateCourseLecturer(Lecturers facultyObject, Course course, List courseList) {

        if (facultyObject.getAssignedCourses().size() < facultyObject.MAXIMUM_NUMBER_OF_COURSE) {
            facultyObject.getAssignedCourses().add(course.getCourseCode());
            course.setSigned(true);
            updateCourseList(courseList, course);

        } else {
            try {
                throw new IllegalArgumentException("This faculty member is exceeded his maximum number of courses.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

    public void dropCourseForLecturer(Lecturers facultyObject, Course course) {
        if (facultyObject.getAssignedCourses() == null) {
            try {
                throw new IllegalArgumentException(" This faculty member have not any assigned course yet!! ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            facultyObject.getAssignedCourses().remove(course.getCourseCode());

        }
    }

    public boolean isThisTAAbleToTakeThisCourse(TAs tasList, Course courseObj, List<Course> courseList) {

        int totalHours = 0;
        for (int index = 0; index < courseList.size(); index++) {
            for (int index2 = 0; index2 < tasList.getAssignedCourses().size(); index2++) {
                if (tasList.getAssignedCourses().get(index2).equalsIgnoreCase(courseList.get(index).getCourseCode())) {
                    totalHours += courseList.get(index).getCreditHours();
                }
            }
        }

        totalHours += courseObj.getCreditHours();

        if (totalHours > tasList.QUOTA_OF_CREDIT_HOURS) {
            return false;
        } else {
            return true;
        }

    }

    public boolean isThisLecturerAbleToTakeThisCourse(Lecturers lecturerObj, Course courseObj, List<Course> courseList) {
        int totalHours = 0;
        for (int index = 0; index < courseList.size(); index++) {
            for (int index2 = 0; index2 < lecturerObj.getAssignedCourses().size(); index2++) {
                if (lecturerObj.getAssignedCourses().get(index2).equalsIgnoreCase(courseList.get(index).getCourseCode())) {
                    totalHours += courseList.get(index).getCreditHours();
                }

            }

        }

        totalHours += courseObj.getCreditHours();

        if (totalHours > lecturerObj.QUOTA_OF_CREDIT_HOURS) {
            return false;
        } else {
            return true;
        }
    }

    public String findCourseInfoByCourseCode(String courseCode, List<Course> courseList) {

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

    public void printFacultyMembersDetails(List<TAs> tasList, List<Lecturers> lecturer, List<Course> courseList) {

        for (int index = 0; index < tasList.size(); index++) {
            System.out.println("\nFacultyID : " + tasList.get(index).getFacultyId() + "\nFull Name : " + tasList.get(index).getFullName()
                    + "\nAcademicRank : " + tasList.get(index).getAcademicRank()
                    + "\nAcademicSpecialization : " + tasList.get(index).getAcademicSpecialization() + "\n Courses:  ");

            for (int courseIndex = 0; courseIndex < tasList.get(index).getAssignedCourses().size(); courseIndex++) {
                System.out.println(findCourseInfoByCourseCode(tasList.get(index).getAssignedCourses().get(courseIndex), courseList));
            }
        }
        for (int index = 0; index < lecturer.size(); index++) {
            System.out.println("\nFacultyID : " + lecturer.get(index).getFacultyId() + "\nFull Name : " + lecturer.get(index).getFullName()
                    + "\nAcademicRank : " + lecturer.get(index).getAcademicRank()
                    + "\nAcademicSpecialization : " + lecturer.get(index).getAcademicSpecialization() + "\n Courses:  ");

            for (int courseIndex = 0; courseIndex < lecturer.get(index).getAssignedCourses().size(); courseIndex++) {
                System.out.println(findCourseInfoByCourseCode(lecturer.get(index).getAssignedCourses().get(courseIndex), courseList));
            }

        }
    }

    public TAs getTAByFacultyID(List<TAs> tasList, int facultyID) {
        TAs ta = new TAs();

        for (int index = 0; index < tasList.size(); index++) {
            if (tasList.get(index).getFacultyId() == facultyID) {
                ta.setFacultyId(facultyID);
                ta.setFirstName(tasList.get(index).getFirstName());
                ta.setLastName(tasList.get(index).getLastName());
                ta.setAcademicRank(tasList.get(index).getAcademicRank());
                ta.setAcademicSpecialization(tasList.get(index).getAcademicSpecialization());
                ta.setAssignedCourses(tasList.get(index).getAssignedCourses());

            }
        }

        return ta;
    }

    public Lecturers getLecturerByFacultyID(List<Lecturers> lecturerList, int facultyID) {
        Lecturers lecturer = new Lecturers();

        for (int index = 0; index < lecturerList.size(); index++) {
            if (lecturerList.get(index).getFacultyId() == facultyID) {
                lecturer.setFacultyId(facultyID);
                lecturer.setFirstName(lecturerList.get(index).getFirstName());
                lecturer.setLastName(lecturerList.get(index).getLastName());
                lecturer.setAcademicRank(lecturerList.get(index).getAcademicRank());
                lecturer.setAcademicSpecialization(lecturerList.get(index).getAcademicSpecialization());
                lecturer.setAssignedCourses(lecturerList.get(index).getAssignedCourses());

            }
        }

        return lecturer;
    }

    public Course getCourseByCourseCode(List<Course> courseList, String courseCode) {
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

    public void comprehensiveReport(List<TAs> tasList, List<Lecturers> lecturer, List<Course> course) {
        taibahCSObj.printFacultyMembersDetails(tasList, lecturer, course);
        taibahCSObj.printUnallocatedCourseList(course);
    }

    public void printUnallocatedCourseList(List<Course> course) {
        boolean isHeaderPrinted = false;

        if (course.isEmpty()) {
            System.out.println(" There is no course in the system");

        } else {

            for (int index = 0; index < course.size(); index++) {
                System.out.println("");
                if (!course.get(index).isSigned()) {
                    if(isHeaderPrinted == false)
                    {
                        System.out.println("These are the unllocated courses you have added in the system.");
                        System.out.println(COURSE_LIST_HEADER);
                        isHeaderPrinted = true;
                    }

                    System.out.println(course.get(index).getCourseCode() + " " + course.get(index).getCourseName() + " " + course.get(index).getCreditHours());
                }

            }
        }
    }

    public void updateCourseList(List<Course> courseList, Course course) {
        for (int index = 0; index < courseList.size(); index++) {
            if (courseList.get(index).getCourseCode().equalsIgnoreCase(course.getCourseCode())) {
                courseList.set(index, course);
            }
        }
    }

}
