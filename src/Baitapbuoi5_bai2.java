import java.util.Scanner;

//Viết chương trình nhập vào Họ tên, tuổi, giới tính, mã số sinh viên. Và in ra các thông tin trên ra màn hình
public class Baitapbuoi5_bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the full name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the age: ");
        int age = scanner.nextInt();

        // Consume the newline character left in the buffer
        scanner.nextLine();

        System.out.print("Enter the student ID: ");
        String studentID = scanner.nextLine();

        System.out.println("Student name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: "+ studentID);
        scanner.close();
    }
}
