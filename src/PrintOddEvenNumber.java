//1. In tất cả số nguyên dương lẻ / chẵn nhỏ hơn 100. (Viết cả while và for) -
//        Dùng bước nhảy và dùng % 2

public class PrintOddEvenNumber {
    public static void main(String[] args) {
        System.out.println("Using loop");
        System.out.print("Even number: ");
        int i = 0;
        for (i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i+",");
            }
        }
        System.out.println();
        System.out.print("Odd number: ");
        for (i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.print(i+",");
            }
        }
        System.out.println();
        System.out.println("Using while()");
        i = 0;
        System.out.print("Even number: ");
        while( i < 100) {
            if (i % 2 == 0) {
                System.out.print(i+",");
            }
            i++;
        }
        System.out.println();
        System.out.print("Odd number: ");
        i = 0;
        while( i < 100) {
            if (i % 2 != 0) {
                System.out.print(i+",");
            }
            i++;
        }
    }
}
