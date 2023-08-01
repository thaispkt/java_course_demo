package Baitapbuoi6;

import java.util.Scanner;

public class Baitapbuoi6_array_average {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        Scanner scanner = new Scanner(System.in);
//        int sum = 0;
        float sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Enter the value of element "+i+" : ");
            arr1[i]=scanner.nextInt();
            sum += arr1[i];
        }
        float average = sum/arr1.length; // cho nay neu khai bao sum la integer thi
        // ket qua tra ve se la so nguyen ngay ca khi co so thap phan. VD: 16/3=3.2 thi
        // avarage se chi nhan gia tri la 3 thay vi 3.2 du average khai bao la float
        System.out.printf("Avarage of array is %.2f",average);
    }
}
// Có hai kiểu dữ liệu số thực trong Java là float và double
// float: single precision
// double: double precision