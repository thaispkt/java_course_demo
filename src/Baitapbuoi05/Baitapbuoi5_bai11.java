package Baitapbuoi05;//Bài tập 3
//        – Nhập vào 2 số nguyên a,b từ bàn phím
//        – Tính tổng 2 số nguyên a,b và in kết quả ra màn hình console.

import java.util.Scanner;

public class Baitapbuoi5_bai11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 1st integer: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter 2nd integer: ");
        int num2 = scanner.nextInt();
        int sum = num1 + num2;
        System.out.println("Sum of 2 integers: " + sum);
        scanner.close();
    }
}
