//Bài 8: Viết chương trình giải phương trình sau ax^2 + b = 0 trong đó a,b là 2 số người dùng nhập vào màn hình.

import java.util.Scanner;

public class Baitapbuoi5_bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float a = 0;
        do {
            System.out.print("Enter a: ");
            a = scanner.nextFloat();
            if (a == 0) {
                System.out.println("The value of a must be non-zero. Please try again.");
            }
        } while (a == 0);
        float b = 0;
        do {
            System.out.print("Enter b: ");
            b = scanner.nextFloat();
            if (a * b > 0) {
                if (a > 0) {
                    System.out.println("b must be negative number. Please try again.");
                } else {
                    System.out.println("b must be positive number. Please try again.");
                }
            }
        } while (a * b > 0);
        float x = (float) Math.sqrt(-b / a);
        // print the value of 'x' with two decimal places
        System.out.printf("The solution for the equation is x=%.2f", x);
        scanner.close();
    }
}
