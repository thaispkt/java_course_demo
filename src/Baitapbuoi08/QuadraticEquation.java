package Baitapbuoi08;
/*
Viết chương trình khai báo một lớp Phương trình bậc 2 với các thuộc tính là a, b, c với các phương thức sau:
•	Hàm tạo không tham số.
•	Hàm tạo có 3 tham số.
•	Get/set cho 3 thuộc tính.
•	Phương thức tính delta.
•	Phương thức tính nghiệm phương trình.
 */
public class QuadraticEquation {
    private float a;
    private float b;
    private float c;

    public QuadraticEquation() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public QuadraticEquation(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Getters and setters for a, b, and c
    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }

    // Method to calculate the discriminant (delta)
    public float calculateDelta() {
        return b * b - 4 * a * c;
    }

    // Method to calculate the solutions of the equation
    public void solve() {
        float delta = calculateDelta();

        if (a == 0) {
            System.out.println("Error: a cannot be zero");
        } else if (delta < 0) {
            System.out.println("The equation has no solutions.");
        } else if (delta == 0) {
            float x = -b / (2 * a);
            System.out.println("The equation has a double root: x = " + x);
        } else {
            float x1 = (float) (-b + Math.sqrt(delta)) / (2 * a);
            float x2 = (float) (-b - Math.sqrt(delta)) / (2 * a);
            System.out.printf("The equation has 2 distinct roots: x1 = %.2f, x2 = %.2f", x1, x2);
        }
    }
}
