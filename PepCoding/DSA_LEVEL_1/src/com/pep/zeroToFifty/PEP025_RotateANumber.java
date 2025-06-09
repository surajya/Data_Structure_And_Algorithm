package com.pep.zeroToFifty;

import java.util.Scanner;

public class PEP025_RotateANumber {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your number: ");
            int number = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter number of rotations: ");
            int rotation = Integer.parseInt(scanner.nextLine());

            int rotatedNumber = rotateNumber(number, rotation);
            System.out.println("Rotated number: " + rotatedNumber);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers.");
        }
    }

    /**
     * Rotates the digits of the given number to the right by 'rotation' places.
     *
     * @param number   the original number
     * @param rotation the number of times to rotate
     * @return the rotated number
     */
    private static int rotateNumber(int number, int rotation) {
        int totalDigits = countDigits(number);
        rotation = rotation % totalDigits;
        if (rotation < 0) {
            rotation += totalDigits; // Handle negative rotation if needed
        }

        int power = (int) Math.pow(10, rotation);
        int front = number % power;
        int back = number / power;

        int rotated = front * (int) Math.pow(10, totalDigits - rotation) + back;
        return rotated;
    }

    /**
     * Counts the number of digits in the given number.
     *
     * @param num the number
     * @return the count of digits
     */
    private static int countDigits(int num) {
        return (num == 0) ? 1 : (int) Math.log10(num) + 1;
    }
}
