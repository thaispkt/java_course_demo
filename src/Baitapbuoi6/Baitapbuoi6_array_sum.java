package Baitapbuoi6;

import java.util.Scanner;
public class Baitapbuoi6_array_sum {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        inputArrayValue(arr1);
        printArray(arr1);
        System.out.println("Sum of array elements: " + sumArray(arr1));
    }
    public static void inputArrayValue(int[] arr) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the value for element "+i+" = ");
            arr[i] = scanner.nextInt();
        }
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr["+i+"]="+arr[i]);
        }
    }
    public static int sumArray(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }
}
