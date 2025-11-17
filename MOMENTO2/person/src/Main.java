//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Persona");
        Person person1 = new Person("Alberto", "Calle 123");
        Person person2 = new Person("Maria", "Avenida 456");

        System.out.println(person1.toString());
        System.out.println(person2.toString());

        System.out.println("\nEstudiante");
        Student student1 = new Student("Carlos", "Calle 789", "Ingeniería", 2, 4000000);
        Student student2 = new Student("Ana", "Avenida 321", "Medicina", 3, 10000000);

        System.out.println(student1.toString());
        System.out.println(student2.toString());

        System.out.println("\nPersonal");
        Staff staff1 = new Staff("Luis", "Calle 654", "Universidad X", 2500000);
        Staff staff2 = new Staff("Sofia", "Avenida 987", "Universidad Y", 3000000);

        System.out.println(staff1.toString());
        System.out.println(staff2.toString());
    }
}