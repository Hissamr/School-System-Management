package Models;

/**
 * This class is responsible for keeping track of
 * the teachers name, id, classes, salary, specialization information
 */

public class Teacher {

    private String name;
    private final int id;
    private int salary;
    private String specialization;
    private ClassGroup classRoom;

    /**
     * To create a new teacher by initializing.
     * @param name name of the teacher.
     * @param id id of the teacher(unique).
     * @param specialization area of specialization.
     * @param salary salary of the teacher.
     */
    public Teacher(String name, int id, String specialization, int salary){
        this.name = name;
        this.id = id;
        this.specialization = specialization;
        this.salary = salary;
    }

    /**
     * To get the name of the teacher
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /**
     * To get the salary of the teacher
     * @return salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * To get the specialization of the teacher
     * @return specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * To get the teacher id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * To assign the teacher to the classRoom
     * @param classRoom classRoom object.
     */
    public void setClassRoom(ClassGroup classRoom) {
        this.classRoom = classRoom;
    }

    /**
     * To get the class of teacher
     * @return classGroup
     */
    public ClassGroup getClassGroup() {
        return classRoom;
    }

    /**
     * To return the information of the Teacher
     * @return String.
     */
    @Override
    public String toString() {

        /**
         * To check whether the teacher is assigned to the classRoom or not
         * to avoid the null pointer Exception.
         */
        String classInfo = (classRoom != null)
                ? "Grade " + classRoom.getGrade() + " Section " + classRoom.getSection()
                : "Not Assigned";

        return "Teacher {\n" +
                "\tname: '" + name + "',\n" +
                "\tid: " + id + ",\n" +
                "\tsalary: " + salary + ",\n" +
                "\tspecialization: '" + specialization + "',\n" +
                "\tclass: " + classInfo + "\n" +
                "}";
    }
}
