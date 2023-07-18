//Cũng yêu cầu như câu 2, nhưng cho phép Hỏi người dùng muốn xuất theo thứ tự nào, nếu người dùng chọn 1 thì xuất Tăng dần, người dùng chọn 2 thì xuất giảm dần.

import java.util.Scanner;
public class Baitapbuoi3_bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int n1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int n2 = scanner.nextInt();

        System.out.print("Enter the third number: ");
        int n3 = scanner.nextInt();

        System.out.print("Enter the option (1 for ascending, 2 for descending): ");
        int direction = scanner.nextInt();

        int tmp;
        if (n1 > n2) {
            tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        if (n1 > n3) {
            tmp = n1;
            n1 = n3;
            n3 = tmp;
        }
        if (n2 > n3) {
            tmp = n2;
            n2 = n3;
            n3 = tmp;
        }

        if (direction == 1) {
            System.out.println("Ascending numbers: " + n1 + ", " + n2 + ", " + n3);
        } else if (direction == 2) {
            System.out.println("Descending numbers: " + n3 + ", " + n2 + ", " + n1);
        } else {
            System.out.println("Invalid input");
        }

        scanner.close();
    }
}
