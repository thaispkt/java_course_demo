package Baitapbuoi05;

import java.util.Scanner;

//1.	Viết hàm tìm số Iớn nhất trong 3 số a,b, c do người dùng nhập vào
public class Baitapbuoi5_bai01 {
    public static void main(String[] args) {
        FindMax();
    }
    public static void FindMax() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = scanner.nextInt();
        System.out.print("Enter b: ");
        int b = scanner.nextInt();
        System.out.print("Enter c: ");
        int c = scanner.nextInt();
        scanner.close();
        int max = a;
        if(b > max) {
            max = b;
        }
        if(c > max) {
            max = c;
        }
        System.out.println("Max of a, b and c is: " + max);
        scanner.close();
    }
}
