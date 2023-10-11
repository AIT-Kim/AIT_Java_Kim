package lesson_26.animals;
/**
 * 11.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Cat extends Animal {

    public Cat(){
        super("Myauuuu");
    }

    @Override
    public void sound(){
        System.out.println("Cat say Meow!");
    }

    public void sayHello() {
        System.out.println("Hello from Cat");
    }
}