package Handlers;

import Exceptions.InvalidInputException;
import Models.Block;
import Utils.InputValidator;

import java.util.Scanner;

/**
 * This class is responsible for keeping track of block inputs.
 * It implements the InputHandler interface and provides a method to take input for Block objects.
 */

public class BlockInputHandler implements InputHandler<Block>{

    private final Scanner scanner = new Scanner(System.in);

    /**
     * This method takes input from the user for a Block object.
     * It validates the input using the InputValidator class.
     *
     * @return a Block object with the provided input.
     * @throws InvalidInputException if the input is invalid.
     */
    @Override
    public Block takeInput(){
        System.out.print("Enter Building Name: ");
        String name = scanner.nextLine();

        if (!InputValidator.isValidName(name)) {
            throw new InvalidInputException("Invalid name. Name should only contain letters and spaces.");
        }

        System.out.print("Enter floors: ");
        int floors = scanner.nextInt();
        scanner.nextLine();

        if (!InputValidator.isValidFloors(floors)) {
            throw new InvalidInputException("Invalid number of floors. Floors should be a positive integer.");
        }

        return new Block(name, floors);
    }
}
