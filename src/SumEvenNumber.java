import java.util.Scanner;

//2. Tính tổng các số chẵn từ 1 đến n. Với n nhập từ người dùng (While và for)
public class SumEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Type a number n = ");
        int userNumberInput = scanner.nextInt();
        int sum = 0;
        int i = 0;
        System.out.println("Using for()");
        for (i = 1; i <= userNumberInput; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("sum = " + sum);
        System.out.println("Using while()");
        i = 1;
        sum = 0;
        while(i <= userNumberInput) {
            if (i % 2 == 0) {
                sum += i;
            }
            i++;
        }
        System.out.println("sum = " + sum);
    }
}
