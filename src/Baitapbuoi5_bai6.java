//Bài tập 6: Viết chương trình xuất ra tiếng kêu của các con vật chó, mèo, chuột, ngựa. Trong đó người dùng sẽ nhập
// vào con vật mà người dùng muốn xem tiếng kêu. Ví dụ người dùng nhập chó chương trình sẽ xuất ra “gâu gâu”.

import java.util.Scanner;

public class Baitapbuoi5_bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the animal name: ");
        String animal = scanner.nextLine().toLowerCase();
        switch (animal) {
            case "dog":
                System.out.println("Gâu gâu");
                break;
            case "cat":
                System.out.println("Meo meo");
                break;
            case "mouse":
                System.out.println("Chít chít");
                break;
            case "horse":
                System.out.println("Hí hí");
                break;
            default:
                System.out.println("Unknow animal");
                break;
        }
        scanner.close();
    }
}
