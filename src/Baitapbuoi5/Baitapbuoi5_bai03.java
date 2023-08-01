package Baitapbuoi5;

import java.util.Scanner;

//3.	Viết hàm tính tổng 3 số do người dùng nhập vào
public class Baitapbuoi5_bai03 {
    public static void main(String[] args) {
        System.out.println("Sum of a, b and c is: " + sumABC());
    }
    public static int sumABC() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = scanner.nextInt();
        System.out.print("Enter b: ");
        int b = scanner.nextInt();
        System.out.print("Enter c: ");
        int c = scanner.nextInt();
        scanner.close();
        int sum = a + b +c ;
        return sum;
    }
}
