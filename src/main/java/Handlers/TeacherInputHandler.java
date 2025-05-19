package Handlers;

import Exceptions.InvalidInputException;
import Models.Teacher;
import Utils.InputValidator;

import java.util.Scanner;

/**
 * This class is responsible for keeping track teacher inputs.
 * It implements the InputHandler interface and provides a method to take input for Teacher objects.
 */

public class TeacherInputHandler implements InputHandler<Teacher> {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * This method takes input from the user for a Teacher object.
     * It validates the input using the InputValidator class.
     *
     * @return a Teacher object with the provided input.
     * @throws InvalidInputException if the input is invalid.
     */
    @Override
    public Teacher takeInput(){
        System.out.print("Enter Teacher Name: ");
        String name = scanner.nextLine();

        if(!InputValidator.isValidName(name)) {
            throw new InvalidInputException("Invalid name. Name should only contain letters and spaces.");
        }

        System.out.print("Enter Teacher ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if(!InputValidator.isValidId(id)) {
            throw new InvalidInputException("Invalid ID. ID should be a positive integer.");
        }

        System.out.print("Enter the Specialization: ");
        String specialization = scanner.nextLine();

        if(!InputValidator.isValidSpecialization(specialization)) {
            throw new InvalidInputException("Invalid specialization. Specialization should only contain letters and spaces.");
        }

        System.out.print("Enter the Salary: ");
        int salary = scanner.nextInt();
        scanner.nextLine();

        if(!InputValidator.isValidSalary(salary)) {
            throw new InvalidInputException("Invalid salary. Salary should be a positive integer.");
        }

        return new Teacher(name, id, specialization, salary);
    }

}
