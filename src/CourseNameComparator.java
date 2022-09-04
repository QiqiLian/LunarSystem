import java.util.Comparator;

/** This method compares the courses by alphabetical order
 *
 */
public class CourseNameComparator implements Comparator<Course> {

    /** This method compares the courses based on their department
     * @param e1
     * @param e2
     * @return
     */
    public int compare(Course e1, Course e2) {
        String courseName1 = e1.getDepartment() + " " + e1.getNumber();
        String courseName2 = e2.getDepartment() + " " + e2.getNumber();

        return courseName1.compareTo(courseName2);
    }
}




