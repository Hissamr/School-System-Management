package Handlers;

import Exceptions.InvalidInputException;
import Models.ClassGroup;
import Utils.InputValidator;

import java.util.Scanner;

/**
 * This class is responsible for keeping track of class group inputs.
 * It implements the InputHandler interface and provides a method to take input for ClassGroup objects.
 */

public class ClassGroupInputHandler implements InputHandler<ClassGroup>{

    private final Scanner scanner = new Scanner(System.in);

    /**
     * This method takes input from the user for a ClassGroup object.
     * It validates the input using the InputValidator class.
     *
     * @return a ClassGroup object with the provided input.
     * @throws InvalidInputException if the input is invalid.
     */
    @Override
    public ClassGroup takeInput(){
        System.out.print("Class Grade: ");
        int grade = scanner.nextInt();
        scanner.nextLine();

        if (!InputValidator.isValidGrade(grade)) {
            throw new InvalidInputException("Invalid grade. Grade should be a positive integer.");
        }

        System.out.print("Class Section: ");
        char section = scanner.next().charAt(0);

        if (!InputValidator.isValidSection(section)) {
            throw new InvalidInputException("Invalid section. Section should be a single uppercase letter.");
        }

        return new ClassGroup(grade, section);
    }
}
