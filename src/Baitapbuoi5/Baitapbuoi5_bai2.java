package Baitapbuoi5;

import java.util.Scanner;

//2.	Viết hàm kiểm tra một số do người dùng nhập vào là số chẵn hay lẻ
public class Baitapbuoi5_bai2 {
    public static void main(String[] args) {
        if(isEvenNum()) {
            System.out.println("n is even number");
        } else {
            System.out.println("n is odd number");
        }
    }

    public static boolean isEvenNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        scanner.close();
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
