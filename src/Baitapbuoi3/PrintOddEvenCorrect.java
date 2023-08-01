package Baitapbuoi3;

public class PrintOddEvenCorrect {
    public static void main(String[] args) {
        String EvenNumber = "";
        String OddNumber = "";
        for (int i = 1; i < 100; i++) {
            if(i % 2 == 0) {
                EvenNumber += i + ","; // EvenNumber = EvenNumber + i
            } else {
                OddNumber += i + ",";
            }
        }
        System.out.println("Even number list: " + EvenNumber);
        System.out.println("Odd number list: "+ OddNumber);
        int i = 1;
        EvenNumber = "";
        OddNumber = "";
        while(i<100) {
            if(i % 2 == 0) {
                EvenNumber += i + ","; // EvenNumber = EvenNumber + i
            } else {
                OddNumber += i + ",";
            }
            i++;
        }
        System.out.println("Even number list: " + EvenNumber);
        System.out.println("Odd number list: "+ OddNumber);
    }
}
