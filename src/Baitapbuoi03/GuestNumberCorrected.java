package Baitapbuoi03;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class GuestNumberCorrected {
    public static void main(String[] args) {
        int randomNumber = (int) (Math.random()*999+1);
        int userGuessNumber = 0;
        Scanner scanner = new Scanner (System.in);
        do {
            System.out.println("Please guess a number: ");
            userGuessNumber = scanner.nextInt();
            if (userGuessNumber > randomNumber) {
                System.out.println("Your guess number is greater than secret number");
            } else if (userGuessNumber < randomNumber) {
                System.out.println("Your guess number is less than secret number");
            }
        } while (userGuessNumber == randomNumber);
        System.out.println("You have guessed correct number " + userGuessNumber + " - Secret number " + randomNumber);
    }
}