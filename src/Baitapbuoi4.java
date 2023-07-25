import java.util.Scanner;

/* Cho người dùng nhập vào n số nguyên và lưu trữ trong mảng
        a. Viết hàm nhập, hàm xuất
        b. Tìm số lớn nhất và vị trí của nó trong mảng
        c. Tìm số âm đầu tiên và vị trí của nó trong mảng
        d. Tìm số âm lớn nhất và vị trí của nó trong mảng
        e. Tính tổng các số chẵn.
        f. Đếm có bao nhiêu số âm.
        g. Tổng các số âm.
        h. Cho người dùng nhập vào x và tìm x có trong mảng đó hay không.
*/
public class Baitapbuoi4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = EnterArray(scanner);
        printArray(array);
        printArray2(array); // use foreach
        FindMaxNumber(array);
        FindFirstNegativeNumber(array);
        FindMaxNegativeNumber(array);
        SumEvenNumber(array);
        CountNegativeNumber(array);
        SumNegativeNumber(array);
        FindX(scanner, array);
        scanner.close();
    }

    public static int[] EnterArray(Scanner scanner) {
        int arrSize = 0;
        do {
            System.out.print("Enter the array size: ");
            arrSize = scanner.nextInt();
            if (arrSize <= 0) {
                System.out.println("Array size cannot be zero or negative. Try again");
            }
        } while (arrSize <= 0);
        int arr[] = new int[arrSize];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the value for element " + i + " in array: ");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    //
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "]=" + arr[i]);
        }
    }

    public static void printArray2(int[] arr) {
        for (int n : arr) {
            System.out.println(" n = " + n);
        }
    }

    public static void FindMaxNumber(int[] arr) {
        int largestNum = arr[0];
        int largestNumIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largestNum) {
                largestNum = arr[i];
                largestNumIndex = i;
            }
        }
        System.out.println("The largest number in the array is " + largestNum + " at index " + largestNumIndex);
    }

    public static void FindFirstNegativeNumber(int[] arr) {
        int FirstNegativeNum = 0;
        int FirstNegativeNumIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                FirstNegativeNum = arr[i];
                FirstNegativeNumIndex = i;
                break;
            }
        }
        if (FirstNegativeNumIndex == -1) {
            System.out.println("Not found negative number in the array");
        } else {
            System.out.println("The first negative number in the array is " + FirstNegativeNum +
                    " at " + "index " + FirstNegativeNumIndex);
        }
    }

    public static void FindMaxNegativeNumber(int[] arr) {
        int MaxNegativeNum = Integer.MIN_VALUE;
        int MaxNegativeNumIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (arr[i] > MaxNegativeNum) {
                    MaxNegativeNum = arr[i];
                    MaxNegativeNumIndex = i;
                }
            }
        }
        if (MaxNegativeNumIndex == -1) {
            System.out.println("Not found negative number in the array");
        } else {
            System.out.println("The max negative number in the array is " + MaxNegativeNum + " at" +
                    " " + "index " + MaxNegativeNumIndex);
        }
    }

    public static void SumEvenNumber(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }
        System.out.println("Sum of even numbers is " + sum);
    }

    public static void CountNegativeNumber(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                count++;
            }
        }
        System.out.println("Count of negative number is " + count);
    }

    public static void SumNegativeNumber(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                sum += arr[i];
            }
        }
        System.out.println("Sum of negative numbers is " + sum);
    }

    public static void FindX(Scanner scanner, int[] arr) {
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        boolean isFound = false;
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                isFound = true;
                break;
            }
        }
        if (isFound) {
            System.out.println("Found x in array");
        } else {
            System.out.println("Not found x in array");
        }
    }
}
