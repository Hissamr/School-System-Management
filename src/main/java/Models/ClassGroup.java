package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for keeping track of
 * the students object list , teachers, section, grade, block and total number of students information
 */

public class ClassGroup {

    private int grade;
    private char section;
    private Block block;
    private Teacher teacher;
    private final List<Student> students = new ArrayList<>();
    private int totalStudents;

    public ClassGroup(int grade, char section){
        this.grade = grade;
        this.section = section;
        this.totalStudents = 0;
    }

    /**
     * To get the grade fo the classRoom
     * @return grade.
     */
    public int getGrade(){
        return grade;
    }

    /**
     * To set the grade of the classRoom
     * @param grade grade of the classRoom.
     */
    public void setGrade(int grade){
        this.grade = grade;
    }

    /**
     * To get the section of the classRoom
     * @return section.
     */
    public char getSection() {
        return section;
    }

    /**
     * To set the section of the classRoom
     * @param section section of the classRoom.
     */
    public void setSection(char section) {
        this.section = section;
    }

    /**
     * To get the block of the classRoom
     * @return block.
     */
    public Block getBlock(){
        return block;
    }

    /**
     * To set the block of the classRoom
     * @param block block of the classRoom.
     */
    public void setBlock(Block block){
        this.block = block;
    }

    /**
     * To get the teacher of the classRoom
     * @return teacher.
     */
    public Teacher getClassTeacher(){
        return teacher;
    }

    /**
     * To set the teacher of the classRoom
     * @param classTeacher teacher of the classRoom.
     */
    public void setClassTeacher(Teacher classTeacher){
        /**
         * also set the classRoom to the teacher two-way pointing.
         */
        classTeacher.setClassRoom(this);
        this.teacher = classTeacher;
    }

    /**
     * To get the total number of students in the classRoom
     * @return totalStudents.
     */
    public int getTotalStudents(){
        return totalStudents;
    }

    /**
     * To get List of the students in the classRoom
     * @return students.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * To add the student to the classRoom
     * @param student student object.
     */
    public void addStudents(Student student){
        students.add(student); //add student to the list
        student.setClassRoom(this);// set the classRoom to the student two-way pointing.
        this.totalStudents =  students.size();// change the total student count.
    }

    /**
     * To return the information about the classRoom
     * @return String.
     */
    @Override
    public String toString(){

        //check whether class assign to the block to avoid null pointer exception.
        String blockInfo = (block != null)
                ? "Name " + block.getName() + " Floors " + block.getFloors()
                : "Not Assigned";

        //check whether teacher assign to the class to avoid null pointer exception.
        String teacherInfo = (teacher != null)
                ? teacher.getName() +"Id: "+teacher.getId()
                : "Not Assigned";


        return "Class " + grade + section + " {\n" +
                "\tTeacher: " + teacherInfo + ",\n" +
                "\tStudents: " + this.totalStudents + ",\n" +
                "\tBlock: " + blockInfo + "\n" +
                "}";
    }
}
