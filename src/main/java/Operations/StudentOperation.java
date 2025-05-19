package Operations;

import Exceptions.DuplicateResourceException;
import Exceptions.InvalidInputException;
import Exceptions.ResourceNotFoundException;
import Handlers.StudentInputHandler;
import Models.ClassGroup;
import Models.Student;
import Services.ClassGroupService;
import Services.StudentService;

import java.util.Scanner;

/**
 * This class is responsible for keeping track of the add/Remove student, assign student to class and remove student
 * view students and student list functions
 */

public class StudentOperation {

    private final StudentService studentService;
    private final ClassGroupService classGroupService;
    private final StudentInputHandler studentInputHandler = new StudentInputHandler();
    private final Scanner scanner = new Scanner(System.in);

    public StudentOperation (StudentService studentService, ClassGroupService classGroupService){
        this.studentService = studentService;
        this.classGroupService = classGroupService;
    }

    public void handleStudentOperation(){
        while(true) {
            try {
                System.out.print("""
                        ----------- STUDENT MENU -------------
                        1.Add Student
                        2.View Student
                        3.List All Student
                        4.Assign Student to Class
                        5.Remove Student
                        6.Back to Main Menu
                        ---------------------------------------
                        """);

                System.out.print("Enter choice: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // clear invalid input
                    continue;
                }
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1: {
                        System.out.println("--------  Add Student -----------");

                        //take input from InputHandler
                        Student student = studentInputHandler.takeInput();

                        //add student to the list
                        studentService.addStudent(student);
                        System.out.println("Student Added.");
                        System.out.println("---------------------------------");
                        break;
                    }

                    case 2: {
                        System.out.println("-------- View Student -----------");
                        System.out.print("Enter Student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        //find student by id
                        Student found = studentService.getStudentById(id);
                        if (found != null) {
                            System.out.println(found);
                        } else {
                            System.out.println("Student not found with ID: " + id);
                        }
                        System.out.println("--------------------------------");
                        break;
                    }

                    case 3: {
                        System.out.println("------ Student Lists -------");

                        //List all the student
                        for (Student student : studentService.getAllStudents()) {
                            System.out.println(student);
                        }
                        System.out.println("----------------------------");
                        break;
                    }

                    case 4: {
                        System.out.println("-------- Add Student to Class Room -----------");
                        System.out.print("Enter Student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        //get the student by id
                        Student student = studentService.getStudentById(id);
                        System.out.print("Enter Class Grade: ");
                        int grade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Class section: ");
                        char section = scanner.nextLine().charAt(0);

                        //get the classGroup by grade and section
                        ClassGroup classGroup = classGroupService.getClass(grade, section);

                        if (student != null && classGroup != null) {

                            //add student to the classRoom
                            classGroupService.addStudentToClass(student, classGroup);
                            System.out.println("Student Assign to Class.");
                        } else {
                            System.out.println("Invalid Student ID or class Not found");
                        }
                        System.out.println("--------------------------------------------");
                        break;
                    }

                    case 5: {
                        System.out.println("-------- Remove Student -----------");
                        System.out.print("Enter Student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        //get the student by id
                        Student student = studentService.getStudentById(id);

                        //remove the student from the list
                        studentService.removeStudent(student);
                        System.out.println("Student Removed.");
                        System.out.println("------------------------------------");
                        break;
                    }

                    case 6: {
                        System.out.println("Returning to Main Menu...");
                        return;
                    }

                }
            } catch (ResourceNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (DuplicateResourceException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
