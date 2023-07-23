import java.util.Scanner;

//•	Viết chương trình nhập vào một số và kiểm tra xem số đó có chia hết cho 5 hay không?
//


public class Baitapbuoi5_bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the integer: ");
        int num = scanner.nextInt();
        if (num % 5 == 0) {
            System.out.println(num + " is divisible by 5.");
        } else {
            System.out.println(num + " is not divisible by 5.");
        }
        // Close the Scanner
        scanner.close();
    }
}
