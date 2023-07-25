import java.util.Scanner;

public class Baitapbuoi6_function {
    public static void main(String[] args) {
        /*
        // Ko duoc phep khai bao function trong function ma phai khai bao function trong class
        // function:
        //  - reuse code, ko co lap di lap lai code
        //  - Chia nho code: breakdown small function
        // Function chia lam 2 loai:
        // 1. Function ko co gia tri tra ve: kieu void
        // 2. Function co gia tri tra ve: bao gom tat ca kieu du lieu ngoai tru void
        // Syntax:
        // public kieu_du_lie function_name{tham_so1,tham_so2,..) {
        // logic code
        // }
        Goi ham: function_name(parameter1,...)
        */
        sum(3,6);
        // ko the print bien total vi code scope
        int num1 = 10;
        int num2 = 15;
        sum(num1,num2);
        int result = multipler(num1, num2);
        System.out.println("result = "+result);
        int[] arr1 = new int[5];
        inputArrayValue(arr1);
        printArray(arr1);
        System.out.println("Sum of array elements: " + sumArray(arr1));

    }
    public static void sum(int num1, int num2) { // khi dat function name thi viet thuong chu cai
        //  dau, tranh trung voi class name
        int total = num1 + num2;
        System.out.println("Sum is " + total);
        if(total > 5) {
            System.out.println("Sum is greater than 5");
        } else {
            System.out.println("Sum is less than 5");
        }
    }
    public static int multipler(int num1, int num2) {
        int product = num1 * num2;
        return product;
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
    // Viet ham nhap vao gia tri cua 1 mang 5 phan tu
    // Viet function xuat gia tri 5 phan tu tren
    // Viet function tinh tong gia tri cua mang tren

} // scope cua class
