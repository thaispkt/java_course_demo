import java.util.Scanner;

public class Baitapbuoi6_array_average_correct {
    public static void main(String[] args) {
        float[] arr1 = new float[5];
        Scanner scanner = new Scanner(System.in);
//        int sum = 0;
        float sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Enter the value of element "+i+" : ");
            arr1[i]=scanner.nextFloat();
            sum += arr1[i];
        }
        float average = sum/arr1.length; // cho nay neu khai bao sum la integer thi
        // ket qua tra ve se la so nguyen ngay ca khi co so thap phan. VD: 16/3=3.2 thi
        // avarage se chi nhan gia tri la 3 thay vi 3.2 du average khai bao la float
        System.out.printf("Avarage of array is %.2f",average);
    }
}
