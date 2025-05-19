package Utils;

/**
 * This class is responsible for validating the inputs
 * for the Student, Teacher, ClassGroup and Block classes.
 */

public class InputValidator {

    /**
     * This method is used to validate the name of the student or teacher.
     * @param name name of the student or teacher.
     * @return true if the name is valid, false otherwise.
     */
    public static boolean isValidName(String name){
        return name != null && !name.trim().isEmpty() && name.matches("[a-zA-Z\\s]+");
    }

    /**
     * This method is used to validate the id of the student or teacher.
     * @param id id of the student or teacher.
     * @return true if the id is valid, false otherwise.
     */
    public static boolean isValidId(int id){
        return id > 0;
    }

    /**
     * This method is used to validate the Grade of the classRoom.
     * @param grade grade of the classRoom.
     * @return true if the grade is valid, false otherwise.
     */
    public static boolean isValidGrade(int grade){
        return grade >= 1 && grade <= 12;
    }

    /**
     * This method is used to validate the section of the classRoom.
     * @param section section of the classRoom.
     * @return true if the section is valid, false otherwise.
     */
    public static boolean isValidSection(char section){
        return section >= 'A' && section <= 'Z';
    }

    /**
     * This method is used to validate the Fees of the student.
     * @param fees fees of the student.
     * @return true if the fees is valid, false otherwise.
     */
    public static boolean isValidFees(int fees){
        return fees >= 0;
    }

    /**
     * This method is used to validate the salary of the teacher.
     * @param salary salary of the teacher.
     * @return true if the salary is valid, false otherwise.
     */
    public static boolean isValidSalary(int salary){
        return salary >= 0;
    }

    /**
     * This method is used to validate the specialization of the teacher.
     * @param specialization specialization of the teacher.
     * @return true if the specialization is valid, false otherwise.
     */
    public static boolean isValidSpecialization(String specialization){
        return specialization != null && !specialization.trim().isEmpty() && specialization.matches("[a-zA-Z\\s]+");
    }

    /**
     * This method is used to validate the floors of the block.
     * @param floor floor of the block.
     * @return true if the floor is valid, false otherwise.
     */
    public static boolean isValidFloors(int floor){
        return floor >= 0;
    }

}
