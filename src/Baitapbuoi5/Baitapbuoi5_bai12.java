package Baitapbuoi5;//-	Viết chương trình nhập vào 4 số nguyên a,b,c,d từ bàn phím
//        a)	Tính tổng của 4 số nguyên a,b,c,d
//        b)	Tính hiệu của 4 số nguyên a,b,c,d
//        c)	Tính tích của 2 số nguyên a,b
//        d)	Tính tích của 2 số nguyên c và d
//        e)	Tính kết quả của a – b + c + d

import java.util.Scanner;

public class Baitapbuoi5_bai12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number a: ");
        int a = scanner.nextInt();
        System.out.print("Enter number b: ");
        int b = scanner.nextInt();
        System.out.print("Enter number c: ");
        int c = scanner.nextInt();
        System.out.print("Enter number d: ");
        int d = scanner.nextInt();
        int sum = a + b + c + d;
        System.out.println("Sum of a, b, c and d: " + sum);
        int diff = a - b - c - d;
        System.out.println("Difference of a, b, c and d: " + diff);
        int productAB = a * b;
        System.out.println("Product of a and b: " + productAB);
        int productCD = c * d;
        System.out.println("Product of a and b: " + productCD);
        int expression = a - b + c + d;
        System.out.println("Result of a – b + c + d: " + expression);
    }
}
