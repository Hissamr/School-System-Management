package School;

import Exceptions.DuplicateResourceException;
import Exceptions.InvalidInputException;
import Exceptions.ResourceNotFoundException;
import Operations.BlockOperation;
import Operations.ClassGroupOperation;
import Operations.StudentOperation;
import Operations.TeacherOperation;
import Services.BlockService;
import Services.ClassGroupService;
import Services.StudentService;
import Services.TeacherService;

import java.util.Scanner;

/**
 * This is the main class of the School Management System
 * It is responsible for displaying the menu and handling user input
 */

public class App {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();
        ClassGroupService classGroupService = new ClassGroupService();
        BlockService blockService = new BlockService();

        StudentOperation studentOperation = new StudentOperation(studentService, classGroupService);
        TeacherOperation teacherOperation = new TeacherOperation(teacherService, classGroupService);
        ClassGroupOperation classGroupOperation = new ClassGroupOperation(classGroupService, blockService);
        BlockOperation blockOperation = new BlockOperation(blockService);

        while(true) {
            try {
                System.out.print("""
                        ------- SCHOOL MANAGEMENT SYSTEM --------
                        1.Student Menu
                        2.Teacher Menu
                        3.Class Room Menu
                        4.Block Menu
                        5.Exit
                        -----------------------------------------
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
                        studentOperation.handleStudentOperation();
                        break;
                    }
                    case 2: {
                        teacherOperation.handleTeacherOperation();
                        break;
                    }
                    case 3: {
                        classGroupOperation.handleClassGroupOperation();
                        break;
                    }
                    case 4: {
                        blockOperation.handleBlockOperation();
                        break;
                    }
                    case 5: {
                        System.out.println("Exiting...");
                        System.exit(0);
                    }
                }
            } catch (ResourceNotFoundException | DuplicateResourceException | InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
            }
        }
    }
}
