import java.util.Scanner;

//1. Viết hương trình nhập vào 2 số nguyên m, n. Xác định và xuất số nguyên lớn nhất
public class Baitapbuoi3_bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter m: ");
        int m = scanner.nextInt();

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        int largest = m;
        if (n > m) {
            largest = n;
        }

        System.out.println("The largest number is: " + largest);
        scanner.close();
    }
}
