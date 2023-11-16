package lesson_51.persons;

public class PersonApp {
    public static void main(String[] args) {

        Person person = new Person("john@email.com", "qwertY1!");
        System.out.println(person + " : " + person.getPassword());

        Person person2 = new Person("john@ema%il.com", "qwertyU1");
        System.out.println(person2 + " : " + person2.getPassword());

        Person person3 = new Person("john@email.com", "QWERTY1!");
        System.out.println(person3 + " : " + person3.getPassword());
    }
}