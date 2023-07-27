package Baitapbuoi8_bai2;

public class RectangularApp {
    public static void main(String[] args) {
        Rectangular rectA = new Rectangular(2,5);
        rectA.setInfo(3, 7);
        rectA.printInfo();
        rectA.calcArea();
        rectA.calcPerimeter();
        System.out.println("Area of rectA: " + rectA.area);
        System.out.println("Perimeter of rectA: " + rectA.perimeter);
    }
}
