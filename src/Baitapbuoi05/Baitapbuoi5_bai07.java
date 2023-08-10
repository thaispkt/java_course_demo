package Baitapbuoi05;

import java.util.Scanner;

//7.	Cho biết tên, năm sinh và giới tính của 3 cán bộ. Hãy viết chương trình tìm và in tên cán bộ Nam trẻ nhất.
public class Baitapbuoi5_bai07 {
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
        int MenOfficerBirthYearMinIndex = -1;
        for (int i = 0; i < officers.length; i++) {
            if (officers[i].gender == true) {
                if (isFirstManOfficer) {
                    MenOfficerBirthYearMin = officers[i].birthYear;
                    MenOfficerBirthYearMinIndex = i;
                    isFirstManOfficer = false;
                } else if (officers[i].birthYear < MenOfficerBirthYearMin) {
                    MenOfficerBirthYearMin = officers[i].birthYear;
                    MenOfficerBirthYearMinIndex = i;
                }
            }
        }
        if (MenOfficerBirthYearMinIndex == -1) {
            System.out.println("No male officer found in the above list");
        } else {
            System.out.println("The youngest male officer: " + officers[MenOfficerBirthYearMinIndex].name);
        }
        scanner.close();
    }
}
