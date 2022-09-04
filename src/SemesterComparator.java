import java.util.Comparator;

/** This method compares the semester using the first letter to determine it's alphabetical order
 *
 */
public class SemesterComparator implements Comparator <Course>{
    /** This method compares the semesters of the course
     * @param o1
     * @param o2
     * @return
     */
    public int compare(Course o1, Course o2){
        String semesterName1 = o1.getSemester();
        String semesterName2 = o2.getSemester();

        return semesterName1.compareTo(semesterName2);
    }

}