package Baitapbuoi5;

import java.util.Scanner;

//4.	Xây dựng chương trình tính toán đơn giản cộng, trừ, nhân chia số nguyên
public class Baitapbuoi5_bai4 {
    public static void main(String[] args) {
        calculator();
    }

    public static void calculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = scanner.nextInt();
        System.out.print("Enter b: ");
        int b = scanner.nextInt();
        System.out.println("Menu:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("0. Exit");
        int choice = 0;
        do {
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int sum = a + b;
                    System.out.println("a + b = " + sum);
                    break;
                case 2:
                    int diff = a - b;
                    System.out.println("a - b = " + diff);
                    break;
                case 3:
                    int mul = a * b;
                    System.out.println("a * b = " + mul);
                    break;
                case 4:
                    while (b == 0) {
                        System.out.print("Error: Cannot divide by zero. Please re-enter b: ");
                        b = scanner.nextInt();
                    }
                    float div = (float) a / b;
                    System.out.printf("a / b = %.2f\n", div);
                    break;
                case 0:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
