import java.io.Serializable;

/** This method contains all the courses and it's other data
 *
 */
public class Course implements Serializable {
    private String department;
    private int number;
    private String semester;

    /** This method sets the parameter for the course
     * @param department the department string
     * @param number the department number
     * @param semester the semester of the course
     */
    public Course(String department, int number, String semester) {
        this.department = department;
        this.number = number;
        this.semester = semester;

    }

    /** This method gets the department
     * @return
     */
    public String getDepartment() {
        return department;
    }

    /** This method gets the number for the classes for which the department is in
     * @return
     */
    public int getNumber() {
        return number;
    }

    /** This method gets the semester
     * @return
     */
    public String getSemester() {
        return semester;
    }

    /** This method sets the department
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /** This method sets the number of the department course
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /** This method sets the semester
     * @param semester
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /** This method returns the course comparison
     * @return
     */
    @Override
    public String toString() {
        return department + number + " " +  semester;

    }

    /** This method returns the semester comparison
     * @return \]
     */
    public String string(){
        return department  + number + " " +  semester;
    }
}

