package lesson_50.persons;

public class PersonApp {
    public static void main(String[] args) {

        Person person = new Person("john@email.com", "qwerty");
        System.out.println(person);

        Person person1 = new Person("john.email.com", "qwerty");
        System.out.println(person1);

        Person person2 = new Person("john@ema%il.com", "qwerty");
        System.out.println(person2);
    }
}