package Handlers;

import Exceptions.InvalidInputException;
import Models.Student;
import Utils.InputValidator;

import java.util.Scanner;

/**
 * This class is responsible for keeping track of student inputs.
 * It implements the InputHandler interface and provides a method to take input for Student objects.
 */

public class StudentInputHandler implements InputHandler<Student>{

    private final Scanner scanner = new Scanner(System.in);

    /**
     * This method takes input from the user for a Student object.
     * It validates the input using the InputValidator class.
     *
     * @return a Student object with the provided input.
     * @throws InvalidInputException if the input is invalid.
     */
    @Override
    public Student takeInput() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        if (!InputValidator.isValidName(name)) {
            throw new InvalidInputException("Invalid name. Name should only contain letters and spaces.");
        }

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (!InputValidator.isValidId(id)) {
            throw new InvalidInputException("Invalid ID. ID should be a positive integer.");
        }

        System.out.print("Enter the Total Fees: ");
        int totalFess = scanner.nextInt();
        scanner.nextLine();

        if (!InputValidator.isValidFees(totalFess)) {
            throw new InvalidInputException("Invalid fees. Fees should be a positive integer.");
        }

        return new Student(name, id, totalFess);
    }

}
