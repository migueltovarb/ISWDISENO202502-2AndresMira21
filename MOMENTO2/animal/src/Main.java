//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Mamifero");
        Mammal mammal = new Mammal("Mamifero");
        System.out.println(mammal.toString());

        System.out.println("\nPerro");
        Dog dog = new Dog("Doggo");
        System.out.println(dog.toString());
        dog.greets();
        Dog anotherDog = new Dog("Doggo2");
        dog.greets(anotherDog);

        System.out.println("\nGato");
        Cat cat = new Cat("Michi");
        System.out.println(cat.toString());
        cat.greets();


    }
}