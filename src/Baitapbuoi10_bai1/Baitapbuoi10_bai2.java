package Baitapbuoi10_bai1;

import java.util.Scanner;

/*
Xây dựng lớp vận động viên VanDongVien gồm:
•	Thuộc tính: hoten (chuỗi ký tự), tuoi (số nguyên), monthidau (chuỗi ký tự), cannang (số thực), chieucao (số thực).
•	Phương thức:
•	Khởi tạo không tham số.
•	Khởi tạo 5 tham số
•	Viết phương thức nhập
•	Viết phương thức xuất
•	Viết phương thức so sánh 2 vận động viên > (một vận động viên là lớn hơn nếu chiều cao lớn hơn,
trong trường hợp chiều cao bằng nhau thì xét cân nặng lớn hơn)
 */
public class Baitapbuoi10_bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = scanner.nextInt();
        scanner.close();
        System.out.print("Enter b: ");
        int b = scanner.nextInt();
        scanner.close();
    }
}
