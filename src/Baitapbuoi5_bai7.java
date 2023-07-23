import java.util.Scanner;

//Bài 6: Viết chương trình giải phương trình bậc nhất ax + b = 0 trong đó a, b là 2 số được người dùng nhập vào màn hình
public class Baitapbuoi5_bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float a = 0;
        do {
            System.out.print("Enter a: ");
            a = scanner.nextFloat();
            if (a == 0) {
                System.out.println("The value of a must be non-zero. Please try again.");
            }
        } while (a == 0);
        System.out.print("Enter b: ");
        float b = scanner.nextFloat();
        float x = -b / a;
        // print the value of 'x' with two decimal places
        System.out.printf("The solution for the equation is x=%.2f", x);
        scanner.close();
    }
}
