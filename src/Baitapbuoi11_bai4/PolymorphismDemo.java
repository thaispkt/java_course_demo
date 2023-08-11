package Baitapbuoi11_bai4;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        animal1.makeSound(); // Output: Dog barks
        animal2.makeSound(); // Output: Cat meows
    }
}
