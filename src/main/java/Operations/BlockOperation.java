package Operations;

import Exceptions.DuplicateResourceException;
import Exceptions.InvalidInputException;
import Exceptions.ResourceNotFoundException;
import Handlers.BlockInputHandler;
import Services.BlockService;
import Models.Block;

import java.util.Scanner;

public class BlockOperation {

    private final BlockService blockService;
    private final BlockInputHandler blockInputHandler = new BlockInputHandler();
    private final Scanner scanner = new Scanner(System.in);

    public BlockOperation(BlockService blockService){
        this.blockService = blockService;
    }

    public void handleBlockOperation(){
        while(true){
            try {
                System.out.print("""
                        ----------- Block Menu ---------------
                        1.Add Block
                        2.View Block
                        3.List All Block
                        4.Remove Block
                        5.Back to Main Menu
                        --------------------------------------
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
                        System.out.println("-------- Add Block -----------");

                        //take input from InputHandler
                        Block block = blockInputHandler.takeInput();

                        //add block to the list
                        blockService.addBlock(block);
                        System.out.println("Block Added.");
                        System.out.println("------------------------------");
                        break;
                    }

                    case 2: {
                        System.out.println("-------- View Block -----------");
                        System.out.print("Enter Block Name: ");
                        String name = scanner.nextLine();

                        //get block by name
                        Block block = blockService.getBlockByName(name);
                        System.out.println(block);
                        System.out.println("-------------------------------");
                        break;
                    }

                    case 3: {
                        System.out.println("-------- Block Lists -----------");

                        //get all blocks
                        for (Block block : blockService.getBlockLists()) {
                            System.out.println(block);
                        }
                        System.out.println("-------------------------------");
                        break;
                    }

                    case 4: {
                        System.out.println("-------- Remove Block -----------");
                        System.out.print("Enter Block Name: ");
                        String name = scanner.nextLine();

                        //get block by name
                        Block block = blockService.getBlockByName(name);

                        //remove block
                        blockService.removeBlock(block);
                        System.out.println("Block Removed.");
                        System.out.println("--------------------------------");
                        break;
                    }

                    case 5: {
                        System.out.println("Returning to Main Menu ...");
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
