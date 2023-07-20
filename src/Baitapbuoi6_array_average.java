import java.util.Scanner;

public class Baitapbuoi6_array_average {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Enter the value of element "+i+" : ");
            arr1[i]=scanner.nextInt();
            sum += arr1[i];
        }
        System.out.println("Avarage of array is " + sum/arr1.length);
    }
}
