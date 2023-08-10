package Baitapbuoi05;

import java.util.Scanner;

import static java.lang.Math.sqrt;

//8.	Cho biết tên và tọa độ nhà của 3 sinh viên. Cho biết toạ độ của trường đại học. Hãy viết chương trình cho máy
// in tên sinh viên ở xa trường đại học nhất.
public class Baitapbuoi5_bai08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x position of university: ");
        int xUniPos = scanner.nextInt();
        System.out.print("Enter y position of university: ");
        int yUniPos = scanner.nextInt();
        scanner.nextLine(); // Consume the left new line character in buffer
        Student2[] students = new Student2[3];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student2();
            System.out.print("Enter student name: ");
            students[i].name = scanner.nextLine();
            System.out.print("Enter x position of student's house: ");
            students[i].xPos = scanner.nextInt();
            System.out.print("Enter y position of student's house: ");
            students[i].yPos = scanner.nextInt();
            scanner.nextLine(); // Consume the left new line character in buffer
        }
        double farthestDistance = sqrt((students[0].xPos-xUniPos)^2+ (students[0].yPos-yUniPos)^2);
        int farthestDistanceIndex = 0;
        for (int i = 1; i < students.length; i++) {
            double studenHousedistance = sqrt((students[i].xPos-xUniPos)^2+ (students[i].yPos-yUniPos)^2);
            if (studenHousedistance > farthestDistance) {
                farthestDistance = studenHousedistance;
                farthestDistanceIndex = i;
            }
        }
        System.out.println("The student farthest from the university is: " + students[farthestDistanceIndex].name);
        scanner.close();
    }
}
