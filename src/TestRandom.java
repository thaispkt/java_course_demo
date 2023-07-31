import java.util.Random;
public class TestRandom {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int randomNum = random.nextInt(10);
            System.out.println("Random Number: " + randomNum);
        }
    }
}
