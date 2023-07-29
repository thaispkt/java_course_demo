package Baitapbuoi5;

import java.util.Scanner;

//7.	Cho biết tên, năm sinh và giới tính của 3 cán bộ. Hãy viết chương trình tìm và in tên cán bộ Nam trẻ nhất.
public class Baitapbuoi5_bai7 {
    private static final int OFFICER_NUM_MAX = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Officer[] officers = new Officer[OFFICER_NUM_MAX];
        for (int i = 0; i < officers.length; i++) {
            officers[i] = new Officer(); // Instantiate Officer objects before using them
            System.out.print("Enter name of officer " + (i + 1) + ": ");
            officers[i].name = scanner.nextLine();
            System.out.print("Enter birth year of officer " + (i + 1) + ": ");
            officers[i].birthYear = scanner.nextInt();
            System.out.print("Enter gender of officer " + (i + 1) + ": Male/Female (true/false): ");
            officers[i].gender = scanner.nextBoolean();
            scanner.nextLine(); // Consume the left new line characters in buffer
        }

        boolean isFirstManOfficer = true;
        int MenOfficerBirthYearMin = 0;
        int MenOfficerBirthYearMinIndex = 0;
        for (int i = 0; i < officers.length; i++) {
            /*
            System.out.println("Officer " + (i+1) + ": "+ officers[i].name + ", birth year: " + officers[i].birthYear
                    + ", gender: " + (officers[i].gender ? "Male" : "Female"));
             */
            if(officers[i].gender == true) {
                if(isFirstManOfficer) {
                    MenOfficerBirthYearMinIndex = i;
                    isFirstManOfficer = false;
                    MenOfficerBirthYearMin = officers[i].birthYear;
                } else if(officers[i].birthYear < MenOfficerBirthYearMin) {
                    MenOfficerBirthYearMinIndex = i;
                    MenOfficerBirthYearMin = officers[i].birthYear;
                }
            }
        }
        System.out.println("The youngest officer: " + officers[MenOfficerBirthYearMinIndex].name);
    }
}
