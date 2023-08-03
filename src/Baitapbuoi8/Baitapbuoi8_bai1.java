package Baitapbuoi8;

import java.util.Scanner;

public class Baitapbuoi8_bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        float a = scanner.nextFloat();
        System.out.print("Enter b: ");
        float b = scanner.nextFloat();
        System.out.print("Enter c: ");
        float c = scanner.nextFloat();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        quadraticEquation.solve();
    }
}
