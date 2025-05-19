package Operations;

import Handlers.ClassGroupInputHandler;

import Models.Block;
import Models.ClassGroup;

import Services.BlockService;
import Services.ClassGroupService;

import java.util.Scanner;

public class ClassGroupOperation {

    private final ClassGroupService classGroupService;
    private final BlockService blockService;
    private final ClassGroupInputHandler classGroupInputHandler = new ClassGroupInputHandler();
    private final Scanner scanner = new Scanner(System.in);

    public ClassGroupOperation(ClassGroupService classGroupService, BlockService blockService){
        this.classGroupService = classGroupService;
        this.blockService = blockService;
    }

    public void handleClassGroupOperation(){
        while(true){
            System.out.print("""
                    ----------- Class Room Menu ------------
                    1.Add Class Room
                    2.View Class Room
                    3.List All Class Room
                    4.Add Class Room to Block
                    5.Remove Class Room
                    6.Back to Main Menu
                    ----------------------------------------
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
                    System.out.println("-------- Add Class Room -----------");
                    ClassGroup classRoom = classGroupInputHandler.takeInput();
                    classGroupService.addClassRoom(classRoom);
                    System.out.println("Class Added.");
                    System.out.println("-----------------------------------");
                    break;
                }

                case 2: {
                    System.out.println("-------- View Class Room -----------");
                    System.out.print("Enter Class Grade: ");
                    int grade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Class section: ");
                    char section = scanner.nextLine().charAt(0);
                    ClassGroup classGroup = classGroupService.getClass(grade, section);
                    if (classGroup != null) {
                        System.out.println(classGroup);
                    } else {
                        System.out.println("Class not found with: " + grade + section);
                    }
                    System.out.println("------------------------------------");
                    break;
                }

                case 3: {
                    System.out.println("------ Class Room List -------");
                    for (ClassGroup classRoom : classGroupService.getClassGroupList()) {
                        System.out.println(classRoom);
                    }
                    System.out.println("------------------------------");
                    break;
                }

                case 4: {
                    System.out.println("-------- Add Class Room To Block -----------");
                    System.out.print("Enter Class Grade: ");
                    int grade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Class section: ");
                    char section = scanner.nextLine().charAt(0);
                    ClassGroup classGroup = classGroupService.getClass(grade, section);
                    System.out.print("Enter Block Name: ");
                    String name = scanner.nextLine();
                    Block block = blockService.getBlockByName(name);
                    if (block != null && classGroup != null) {
                        blockService.addClassToBlock(classGroup, block);
                        System.out.println("Class Added to Block.");
                    } else {
                        System.out.println("Invalid Class or Block Not found");
                    }
                    System.out.println("------------------------------------------");
                    break;
                }

                case 5: {
                    System.out.println("-------- Remove Class Room -----------");
                    System.out.print("Enter Class Grade: ");
                    int grade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Class section: ");
                    char section = scanner.nextLine().charAt(0);
                    ClassGroup classGroup = classGroupService.getClass(grade, section);
                    classGroupService.removeClassRoom(classGroup);
                    System.out.println("Class Removed.");
                    System.out.println("---------------------------------------");
                    break;
                }

                case 6: {
                    System.out.println("Returning to Main Menu...");
                    return;
                }
            }
        }
    }
}
