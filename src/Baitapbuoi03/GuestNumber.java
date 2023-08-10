package Baitapbuoi03;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class GuestNumber {
    public static void main(String[] args) {
        int randomNumber = (int) (Math.random()*999+1);
        int userGuessNumber = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap 1 so de doan: ");
            userGuessNumber = scanner.nextInt();
            if (userGuessNumber > randomNumber) {
                System.out.println("Your guest number is greater than the secret number. Try again");
            } else if (userGuessNumber < randomNumber) {
                System.out.println("Your guest number is less than the secret number. Try again");
            } else {
                System.out.println("You guessed the secret number");
                break;
            }
        }
    }
}