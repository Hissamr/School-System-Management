package Operations;

import Exceptions.DuplicateResourceException;
import Exceptions.InvalidInputException;
import Exceptions.ResourceNotFoundException;
import Handlers.TeacherInputHandler;
import Models.ClassGroup;
import Models.Teacher;
import Services.ClassGroupService;
import Services.TeacherService;

import java.util.Scanner;

public class TeacherOperation {

    private final TeacherService teacherService;
    private final ClassGroupService classGroupService;
    private final TeacherInputHandler teacherInputHandler = new TeacherInputHandler();
    private final Scanner scanner = new Scanner(System.in);

    public TeacherOperation(TeacherService teacherService, ClassGroupService classGroupService){
        this.teacherService = teacherService;
        this.classGroupService = classGroupService;
    }

    public void handleTeacherOperation(){
        while(true){
            try {
                System.out.print("""
                        ----------- TEACHER MENU -------------
                        1.Add Teacher
                        2.View Teacher
                        3.List All Teacher
                        4.Assign Teacher to Class
                        5.Remove Teacher
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
                        System.out.println("-------- Add Teacher -----------");

                        //take input from InputHandler.
                        Teacher teacher = teacherInputHandler.takeInput();

                        //add teacher to the list.
                        teacherService.addTeacher(teacher);
                        System.out.println("Teacher Added.");
                        System.out.println("-------------------------------");
                        break;
                    }

                    case 2: {
                        System.out.println("-------- View Teacher -----------");
                        System.out.print("Enter Teacher ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        //find teacher by id.
                        Teacher teacher = teacherService.getTeacherById(id);
                        if (teacher != null) {
                            System.out.println(teacher);
                        } else {
                            System.out.println("Teacher not found with ID: " + id);
                        }
                        System.out.println("---------------------------------");
                        break;
                    }

                    case 3: {
                        System.out.println("------ Teacher Lists -------");

                        //list all teachers.
                        for (Teacher teacher : teacherService.getTeacherList()) {
                            System.out.println(teacher);
                        }
                        System.out.println("---------------------------");
                        break;
                    }

                    case 4: {
                        System.out.println("-------- Add Teacher to Class Room -----------");
                        System.out.print("Enter Teacher ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        //get teacher by id.
                        Teacher teacher = teacherService.getTeacherById(id);
                        System.out.print("Enter Class Grade: ");
                        int grade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Class section: ");
                        char section = scanner.nextLine().charAt(0);

                        //get the class by grade and section.
                        ClassGroup classGroup = classGroupService.getClass(grade, section);

                        if (teacher != null && classGroup != null) {
                            classGroupService.addTeacherToClass(teacher, classGroup);
                            System.out.println("Teacher Assign to Class.");
                        } else {
                            System.out.println("Invalid Teacher ID or class Not found");
                        }
                        System.out.println("----------------------------------------------");
                        break;
                    }

                    case 5: {
                        System.out.println("-------- Remove Teacher -----------");
                        System.out.print("Enter Teacher ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        //get teacher by id.
                        Teacher student = teacherService.getTeacherById(id);

                        //remove teacher from list.
                        teacherService.removeTeacher(student);
                        System.out.println("Teacher Removed.");
                        System.out.println("----------------------------------");
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
