import java.util.Scanner;

public class Baitapbuoi6_array {
    public static void main(String[] args) {
        // Cu phap khoi tao mang: kieu_du_lieu[] ten_bien = new kieudulieu[so phan tu mang]
        int[] arr1 = new int[5]; // mang arr1 co 5 phan tu, index bat dau tu index 0 -> index 4
        // phan tu: item hay element
        // vi tri (index) cua mang bang dau bang so 0
        // assign value : ten_mang[index]=value
        // Khi khao bao va khoi tao gia tri khoi tao cac phan tu mac dinh co gia tri la 0
        arr1[0] = 2;
        arr1[3] = 5;
        System.out.println("arr[1]="+arr1[0]);
        System.out.println("arr[3]="+arr1[3]);
        System.out.println("arr[1]="+arr1[1]);
//        System.out.println("arr[1]="+arr1[5]); // Exception out of bounds for length 5
//        System.out.println("arr[1]="+arr1[-1]); // Exception Index -1 out of bounds for length 5
        // Chieu dai mang (array length)
        int arr1Size= arr1.length;
        System.out.println("arr1Size:"+arr1Size);
        Scanner scanner = new Scanner(System.in);
        // Cach uyet mang (iterate array) qua vong lap for
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Enter the value of element arr1["+i+"]=");
            arr1[i] = scanner.nextInt();
        }
    }
}
