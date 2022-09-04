import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/** This class holds all the data for the student object
 *
 */
public class Student implements Serializable {
    private String webID;
    private ArrayList <Course> courses;

    /** This method hold the required parameter for a student
     * @param webID
     */
    public Student (String webID){
        this.webID = webID;
        courses = new ArrayList<>();
    }


    /**
     * @return This method gets the webID for the students
     */
    public String getWebID() {
        return webID;
    }

    /**
     * @return This method gets the courses for the students
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * @param webID This method sets the webID for the students
     */
    public void setWebID(String webID) {
        this.webID = webID;
    }

    /**
     * @param courses This method sets the courses for the students
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;

    }

    /**
     * This method prints the courses after comparison
     */
    public void printCourses(){
        courses.sort(new CourseNameComparator());
        printAllCourses();

    }

    /**
     * This method obtains all courses being compared
     */
    public void printAllCourses() {
        for(Course course: courses) {
            System.out.println(course.toString());
        }
    }

    /**
     * This method prints the semester after comparison
     */
    public void printSemeseter(){
        courses.sort(new SemesterComparator());
        printAllSemester();

    }

    /**
     * This method obtains all the semester after being compared
     */
    public void printAllSemester(){
        for(Course course: courses) {
            System.out.println(course.string());
        }

    }
}