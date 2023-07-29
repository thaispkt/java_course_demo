package Baitapbuoi7;

import java.util.Scanner;

/*
1. Cho người dùng nhập vào n số nguyên và lưu trữ trong mảng
        a. Làm menu cho người dùng chọn thực hiện các chức năng bên dưới.
        b. Tổng các số dương.
        c. Tính tổng các số lẻ.
        d. Đếm có bao nhiêu số dương.
        e. Tìm số nhỏ nhất trong mảng.
        f. Tìm số dương nhỏ nhất trong mảng
        g. Tìm số chẵn cuối cùng trong mảng 1 chiều các số nguyên. Nếu mảng không có giá trị chẵn thì trả về -1
        h. Viết hàm tìm số chẵn đầu tiên trong mảng các số nguyên. Nếu mảng không có giá trị chẵn thì trả về -1
        i. Tìm số nguyên tố đầu tiên trong mảng 1 chiều các số nguyên. Nếu mảng không có số nguyên tố thì trả về – 1
        j. Tìm số dương cuối cùng trong mảng số thực. Nếu mảng không có giá trị dương thì trả về -1
        k. Hãy tìm giá trị chẵn nhỏ nhất trong mảng 1 chiều các số nguyên. Nếu mảng không có số chẵn thì trả về -1
*/
public class Baitapbuoi7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter value of number " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("0. Sum of positive integers");
        System.out.println("1. Sum of odd integers");
        System.out.println("2. Count of positive integers");
        System.out.println("3. Find min integer");
        System.out.println("4. Find min positive integer");
        System.out.println("5. Find the last even integer");
        System.out.println("6. Find the fist even integer");
        System.out.println("7. Find the first prime number");
        System.out.println("8. Find the last positive integer");
        System.out.println("9. Find the min even number");
        System.out.print("Choose the menu: ");
        int option = scanner.nextInt();
        int result;
        switch (option) {
            case 0:
                System.out.println("Sum of positive integers: " + sumPosInt(arr));
                break;
            case 1:
                System.out.println("Sum of odd integers: " + sumOddInt(arr));
                break;
            case 2:
                System.out.println("Count of positive integers: " + countPosInt(arr));
                break;
            case 3:
                System.out.println("Minimum integer: " + FindMinInt(arr));
                break;
            case 4:
                result = FindMinPosInt(arr);
                if (result == 0) {
                    System.out.println("No positive integer found in the list");
                } else {
                    System.out.println("Minimum positive integer: " + result);
                }
                break;
            case 5:
                result = FindLastEvenInt(arr);
                if (result == -1) {
                    System.out.println("No even integer found in the list");
                } else {
                    System.out.println("Last even integer: " + result);
                }
                break;
            case 6:
                result = FindFirstEvenInt(arr);
                if (result == -1) {
                    System.out.println("No even integer found in the list");
                } else {
                    System.out.println("First even integer: " + result);
                }
                break;
            case 7:
                result = FindFirstPrimeNum(arr);
                if (result == -1) {
                    System.out.println("No prime number found in the list");
                } else {
                    System.out.println("First prime number: " + result);
                }
                break;
            case 8:
                result = FindLastPosInt(arr);
                if (result == -1) {
                    System.out.println("No positive integer found in the list");
                } else {
                    System.out.println("Last positive integer: " + result);
                }
                break;
            case 9:
                result = FindMinEvenInt(arr);
                if (result == -1) {
                    System.out.println("No even integer found in the list");
                } else {
                    System.out.println("Min even number: " + result);
                }
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public static int sumPosInt(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            if (num > 0) {
                sum += num;
            }
        }
        return sum;
    }

    public static int sumOddInt(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                sum += num;
            }
        }
        return sum;
    }

    public static int countPosInt(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num > 0) {
                count++;
            }
        }
        return count;
    }

    public static int FindMinInt(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int FindMinPosInt(int[] arr) {
        int min = 0;
        boolean isFirstPosInt = true;
        for (int num : arr) {
            if (num > 0) {
                if (isFirstPosInt) {
                    min = num;
                    isFirstPosInt = false;
                } else {
                    if (num < min) {
                        min = num;
                    }
                }
            }
        }
        return min;
    }

    public static int FindLastEvenInt(int[] arr) {
        int lastEvenInt = -1;
        for (int num: arr) {
            if (num % 2 == 0) {
                lastEvenInt = num;
            }
        }
        return lastEvenInt;
    }

    public static int FindFirstEvenInt(int[] arr) {
        int firstEvenInt = -1;
        for (int num:arr) {
            if (num % 2 == 0) {
                firstEvenInt = num;
                break;
            }
        }
        return firstEvenInt;
    }

    public static int FindFirstPrimeNum(int[] arr) {
        int primeNum = -1;
        for (int divisor:arr) {
            boolean isPrimeNumDetected = true;
            for (int dividend = 2; dividend < divisor; dividend++) {
                if(divisor % dividend == 0) {
                    isPrimeNumDetected = false;
                    break;
                }
                primeNum = divisor;
            }
            if(isPrimeNumDetected) {
                break;
            }
        }
        return primeNum;
    }
    public static int FindLastPosInt(int[] arr) {
        int num = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                num = arr[i];
            }
        }
        return num;
    }
    public static int FindMinEvenInt(int[] arr) {
        int min = -1;
        for (int num: arr) {
            if (num % 2 == 0) {
                if (num < min) {
                    min = num;
                }
            }
        }
        return min;
    }
}
