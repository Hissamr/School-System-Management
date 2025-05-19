package Services;

import Exceptions.DuplicateResourceException;
import Exceptions.ResourceNotFoundException;
import Models.ClassGroup;
import Models.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for keeping track of the add teacher, assign teacher to class and remove teacher
 * functions
 */

public class TeacherService {

    /**
     * This is the list of teachers
     */
    private final List<Teacher> teacherList = new ArrayList<>();

    /**
     * This method is used to add a teacher to the list
     * @param teacher the teacher to be added
     */
    public void addTeacher(Teacher teacher){
        for(Teacher existingTeacher : teacherList){ //check teacher is already exists or not.
            if(existingTeacher.getId() == teacher.getId()){
                throw new DuplicateResourceException("Teacher with ID " + teacher.getId() + " already exists");
            }
        }
        teacherList.add(teacher);
    }

    /**
     * This method is used to remove a teacher from the list
     * @param teacher the teacher to be removed
     */
    public void removeTeacher(Teacher teacher){
        for(Teacher existingTeacher : teacherList){ //To check whether the teacher is existing or not.
            if(existingTeacher.getId() == teacher.getId()){
                teacherList.remove(teacher);
            }
        }
        throw new ResourceNotFoundException("Teacher with ID " + teacher.getId() + " not found");
    }

    /**
     * This method is used to get a teacher by id
     * @param id the id of the teacher
     * @return the teacher with the given id
     */
    public Teacher getTeacherById(int id){
        for(Teacher teacher: teacherList){
            if(teacher.getId()==id){
                return teacher;
            }
        }
        throw new ResourceNotFoundException("Teacher with ID " + id + " not found");
    }

    /**
     * This method is used to assign a teacher to a class
     * @param teacher the teacher to be assigned
     * @param classRoom the class to be assigned
     */
    public void assignToClass(Teacher teacher, ClassGroup classRoom){
        teacher.setClassRoom(classRoom);
    }

    /**
     * This method is used to get all teachers
     * @return the list of all teachers
     */
    public List<Teacher> getTeacherList(){
        return teacherList;
    }
}
