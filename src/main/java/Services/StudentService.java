package Services;

import Exceptions.ResourceNotFoundException;
import Exceptions.DuplicateResourceException;
import Models.ClassGroup;
import Models.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for keep track of addStudent, getStudent by id, assign to class and
 * getAllStudent functions
 */

public class StudentService {

    /**
     * This is the list of students
     */
    private final List<Student> StudentList = new ArrayList<>();

    /**
     * This method is used to add a student to the list
     * @param student the student to be added
     */

    public void addStudent(Student student){
        for(Student existingStudent : StudentList){ //check existing students
            if(existingStudent.getId() == student.getId()){
                throw new DuplicateResourceException("Student with ID " + student.getId() + " already exists");
            }
        }
        StudentList.add(student);
    }

    /**
     * This method is used to remove a student from the list
     * @param student the student to be removed
     */
    public void removeStudent(Student student){
        for(Student existingStudent : StudentList){ //To check whether the student is existing or not.
            if(existingStudent.getId() == student.getId()){
                StudentList.remove(existingStudent);
            }
        }
        throw new ResourceNotFoundException("Student with ID " + student.getId() + " not found");
    }

    /**
     * This method is used to assign a student to a class
     * @param student the student to be assigned
     * @param classRoom the class to be assigned
     */
    public void assignToClass(Student student, ClassGroup classRoom){
        student.setClassRoom(classRoom);
    }

    /**
     * This method is used to get a student by id
     * @param id the id of the student to be retrieved
     * @return the student with the given id
     */
    public Student getStudentById(int id){
        for(Student student: StudentList){
            if(id == student.getId()){
                return student;
            }
        }
        throw new ResourceNotFoundException("Student with ID " + id + " not found");
    }

    /**
     * This method is used to get all students
     * @return the list of all students
     */
    public List<Student> getAllStudents(){
        return StudentList;
    }

}
