package Models;

/**
 * This class is responsible for keeping track of
 * the students name, id, fees paid and classRoom information
 */

public class Student {

    private String name;
    private final int id;
    private ClassGroup classRoom;
    private final int total_fees;
    private int fees_paid;

    /**
     * To create a new student by initializing.
     * @param name name of the student.
     * @param id unique : id of the student.
     * @param total_fees fees of the student
     */
    public Student(String name, int id, int total_fees){
        this.name = name;
        this.id = id;
        this.total_fees = total_fees;
    }

    /**
     * To get the Student name
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * To get the student id
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * To get the fees Balance of the Student.
     * @return return the student balance which is (total_fees-fees_paid).
     */
    public int getFees_Balance(){
        return total_fees-fees_paid;
    }

    /**
     * To get the total fees of the Student.
     * @return (total_fees) of student.
     */
    public int getTotal_fees(){
        return total_fees;
    }

    /**
     * To get how much fees Student paid.
     * @return (fees_paid) of student.
     */
    public int getFees_paid() {
        return fees_paid;
    }

    /**
     * To pay the student fees.
     * @param fees_paid to add fees to fees_paid.
     */
    public void setFees_paid(int fees_paid){
        this.fees_paid += fees_paid;
    }

    /**
     * To set a class to the student
     * @param classRoom set the student to class
     */
    public void setClassRoom(ClassGroup classRoom){
        this.classRoom = classRoom;
    }

    /**
     * To get the class of the student.
     * @return classRoom of the student.
     */
    public ClassGroup getClassRoom(){
        return classRoom;
    }

    /**
     * To return the information of the Student.
     * @return String
     */
    @Override
    public String toString() {

        /**
         * To check whether class is assigned or not to the student
         * to overcome the null pointer error.
         */
        String classInfo = (classRoom != null)
                ? "Grade " + classRoom.getGrade() + " Section " + classRoom.getSection()
                : "Not Assigned";

        return "Student {\n" +
                "\tname: '" + name + "',\n" +
                "\tid: " + id + ",\n" +
                "\tclass: " + classInfo + ",\n" +
                "\ttotal_fees: " + total_fees + ",\n" +
                "\tfees_paid: " + fees_paid + "\n" +
                "}";    }
}
