package Baitapbuoi3;//Cho người dùng nhập vào 3 số nguyên, viết chương trình xuất 3 số theo thứ tự tăng dần.
import java.util.Scanner;
public class Baitapbuoi3_bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int n1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int n2 = scanner.nextInt();

        System.out.print("Enter the third number: ");
        int n3 = scanner.nextInt();


        int tmp;
        // Using bubble sort algorithm
        // if n1 > n2 then swap n1 and n2 so that the order n1 < n2
        // For ex: n1=7 > n2=3 then swap 3 and 7 -> n1=3 < n2=7
        if (n1 > n2) {
            tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        // if n1 > n3 then swap n1 and n3 so that the order n1 < n3
        // For ex: n1=10 > n3=5 then swap 10 and 3 -> n1=3 < n2=10
        if (n1 > n3) {
            tmp = n1;
            n1 = n3;
            n3 = tmp;
        }
        // if n2 > n3 then swap n2 and n3 so that the order n2 < n3
        // For ex: n2=8 > n3=6 then swap 8 and 6 -> n2=6 < n3=8
        if (n2 > n3) {
            tmp = n2;
            n2 = n3;
            n3 = tmp;
        }

        // Output the sorted integers
        System.out.println("Ascending order number: " + n1 + ", " + n2 + ", " + n3);

        scanner.close();
    }
}
