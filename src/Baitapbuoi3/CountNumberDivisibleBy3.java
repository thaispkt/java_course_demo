package Baitapbuoi3;

//3. Có bao nhiêu số chia hết cho 3 từ 0-1000 (While và for)
public class CountNumberDivisibleBy3 {
    public static void main(String[] args) {
        int i = 0;
        int count = 0;
        System.out.println("Using for()");
        for (i = 0; i <= 1000; i++) {
            if (i % 3 == 0) {
                count ++;
            }
        }
        System.out.println("Number of numbers divisible by 3 = " + count);
        System.out.println("Using while()");
        i = 0;
        count = 0;
        while(i <= 1000) {
            if (i % 3 == 0) {
                count ++;
            }
            i++;
        }
        System.out.println("Number of numbers divisible by 3 = " + count);
    }
}
