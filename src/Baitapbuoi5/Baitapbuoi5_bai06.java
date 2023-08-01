package Baitapbuoi5;

import java.util.Scanner;

//6.	Cho 3 số nguyên. Hãy viết chương trình xuất ra có bao nhiêu số lẻ và bao nhiêu số chẵn.
public class Baitapbuoi5_bai06 {
    private static final int NUMBER_COUNT_MAX = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = new int[NUMBER_COUNT_MAX];
        int evenNumCount = 0;
        int oddNumCount = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the number " + (i+1) + ": ");
            arr[i] = scanner.nextInt();
        }

        for (int num: arr) {
            if(num % 2 == 0) {
                evenNumCount++;
            } else {
                oddNumCount++;
            }
        }
        System.out.println("The number of even numbers: "+ evenNumCount);
        System.out.println("The number of odd numbers: "+ oddNumCount);
        scanner.close();
    }
}
