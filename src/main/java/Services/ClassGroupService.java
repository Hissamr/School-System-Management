package Services;

import Exceptions.DuplicateResourceException;
import Exceptions.ResourceNotFoundException;
import Models.Block;
import Models.ClassGroup;
import Models.Student;
import Models.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for keeping track of the add/Remove classRoom, Assign teacher to class,
 * Assign Student to class
 */

public class ClassGroupService {

    /**
     * This is the list of classRoom
     */
    private final List<ClassGroup> ClassRoomLists = new ArrayList<>();

    /**
     * This method is used to add a classRoom to the list
     * @param classRoom the classRoom to be added
     */
    public void addClassRoom(ClassGroup classRoom){
        for(ClassGroup existingClassRoom : ClassRoomLists){ //check classRoom is already exists or not.
            if(existingClassRoom.getGrade() == classRoom.getGrade() && existingClassRoom.getSection() == classRoom.getSection()){
                throw new DuplicateResourceException("Class with Grade: "+ classRoom.getGrade() + "and Section: " + classRoom.getSection() + "is already exists");
            }
        }
        ClassRoomLists.add(classRoom);
    }

    /**
     * This method is used to remove a classRoom from the list
     * @param classRoom the classRoom to be removed
     */
    public void removeClassRoom(ClassGroup classRoom){
        for(ClassGroup existingClassRoom : ClassRoomLists){ //To check whether the classRoom is existing or not.
            if(existingClassRoom.getGrade() == classRoom.getGrade() && existingClassRoom.getSection() == classRoom.getSection()){
               ClassRoomLists.remove(classRoom);
            }
        }
        throw new ResourceNotFoundException("Class with Grade: "+ classRoom.getGrade() + "and Section: " + classRoom.getSection() + "is Not exists");
    }

    /**
     * This method is used to get a classRoom by grade and section
     * @param grade the grade of the classRoom
     * @param section the section of the classRoom
     * @return the classRoom with the given grade and section
     */
    public ClassGroup getClass(int grade, char section){
        for(ClassGroup classGroup: ClassRoomLists){
            if(classGroup.getGrade() == grade && classGroup.getSection() == section){
                return classGroup;
            }
        }
        throw new ResourceNotFoundException("Class with Grade: "+ grade + "and Section: " + section + "is Not exists");
    }

    /**
     * This method is used to add the student to the classRoom.
     * @param student the student to be added
     * @param classRoom the classRoom to be added
     */
    public void addStudentToClass(Student student, ClassGroup classRoom){
        ClassGroup targetClass = null;

        // Check if the classRoom already exists in the list
        for (ClassGroup existingClassRoom : ClassRoomLists) {
            if (existingClassRoom.getGrade() == classRoom.getGrade() &&
                    existingClassRoom.getSection() == classRoom.getSection()) {
                targetClass = existingClassRoom;
                break;
            }
        }

        // If the classRoom exists, check if the student already exists in that classRoom
        if (targetClass != null) {
            for (Student existingStudent : targetClass.getStudents()) {
                if (existingStudent.getId() == student.getId()) {
                    throw new DuplicateResourceException("Student with ID " + student.getId() + " already exists in this class");
                }
            }
        }
        classRoom.addStudents(student);
    }

    /**
     * This method is used to add the teacher to the classRoom.
     * @param teacher the teacher to be added
     * @param classRoom the classRoom to be added
     */
    public void addTeacherToClass(Teacher teacher, ClassGroup classRoom){
        ClassGroup targetClass = null;

        // Check if the classRoom already exists in the list
        for (ClassGroup existingClassRoom : ClassRoomLists) {
            if (existingClassRoom.getGrade() == classRoom.getGrade() &&
                    existingClassRoom.getSection() == classRoom.getSection()) {
                targetClass = existingClassRoom;
                break;
            }
        }

        // If the classRoom exists, check if the teacher already exists in that classRoom
        if (targetClass != null && targetClass.getClassTeacher().getId() == teacher.getId()) {
            throw new DuplicateResourceException("Teacher with ID " + teacher.getId() + " already exists in this class");

        }
        classRoom.setClassTeacher(teacher);
    }

    /**
     * This method is used to add the block to the classRoom.
     * @param block the block to be added
     * @param classRoom the classRoom to be added
     */
    public void addBlockToClass(Block block, ClassGroup classRoom){
        classRoom.setBlock(block);
    }

    /**
     * This method is used to get all classRoom
     * @return the list of all classRoom
     */
    public List<ClassGroup> getClassGroupList() {
        return ClassRoomLists;
    }
}
