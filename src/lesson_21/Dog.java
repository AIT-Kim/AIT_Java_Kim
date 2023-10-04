package lesson_21;
/**
 * 04.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
import lesson_18.JumpStatus;
/**
 HomeWork
 Будем дорабатывать наш класс Dog. Добавить в класс константу. Использовать эту константу в классе.
 Добавить в класс поле, в котором будет храниться количество прыжков, сделанных всеми объектами класса.
 Добавить в класс статический метод, возвращающий общее количество прыжков, сделанных всеми собаками
 */
public class Dog {
    private String name;               // имя собаки
    private double jumpHeight;         // высота прыжка собаки
    private double initialJumpHeight;  // изначальная высота прыжка (для ограничения максимальной высоты прыжка)
    private static final double MAX_TRAIN_INCREMENT = 10.0;  // максимальное увеличение высоты прыжка на тренировке
    private static int totalJumps = 0; // общее количество прыжков всех собак

    // Конструктор
    public Dog(String name, double jumpHeight) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.initialJumpHeight = jumpHeight;  // сохраняем изначальную высоту прыжка
    }

    // Метод для прыжка собаки
    public void jump() {
        totalJumps++;
        System.out.println(name + " прыгает на высоту " + jumpHeight + " сантиметров!");
    }

    // Метод для тренировки собаки
    public void train() {
        if (jumpHeight < 2 * initialJumpHeight) {
            jumpHeight += MAX_TRAIN_INCREMENT;
            System.out.println(name + " тренировалась и теперь может прыгать на высоту " + jumpHeight + " сантиметров!");
        } else {
            System.out.println(name + " достигла максимальной высоты прыжка!");
        }
    }

    // Метод для прыжка через барьер
    public JumpStatus takeBarrier(double barrierHeight) {
        if (jumpHeight >= barrierHeight) {
            System.out.println(name + " успешно перепрыгнула барьер высотой " + barrierHeight + " сантиметров!");
            return JumpStatus.SUCCESSFUL;
        } else if (2 * initialJumpHeight >= barrierHeight) {
            // проверяем, может ли собака в принципе достичь нужной высоты прыжка
            System.out.println(name + " пока не может перепрыгнуть такой высокий барьер.");
            return JumpStatus.NEED_TRAINING;
        } else {
            System.out.println(name + " никогда не сможет перепрыгнуть барьер такой высоты, даже с тренировками. :(");
            return JumpStatus.UNATTAINABLE;
        }
    }

    public String getName() {
        return name;
    }

    public double getJumpHeight() {
        return jumpHeight;
    }

    public static int getTotalJumps() {
        return totalJumps;
    }
}