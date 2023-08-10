package Baitapbuoi05;//Bài tập 5. Yêu cầu:
//        – Người dùng nhập vào số nguyên n
//        – Kiểm tra số n là chẵn hay lẻ.
//        Ví dụ: n = 2. In ra màn hình 2 là số chẵn; n = 9. In ra màn hình 9 là số lẻ.

import java.util.Scanner;

public class Baitapbuoi5_bai13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = scanner.nextInt();
        if ( num % 2 == 0) {
            System.out.println(num + " is even");
        } else {
            System.out.println(num + " is odd");
        }
    }
}
