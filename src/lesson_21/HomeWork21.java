package lesson_21;

/**
 * 04.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
import lesson_18.JumpStatus;

public class HomeWork21 {
    public static void main(String[] args) {
        int jumpHeight = 30;
        String dogName = "Белла";
        Dog bella = new Dog(dogName, jumpHeight);
        double targetBarrierHeight = 60;

        System.out.printf("\nСоздана собака %s, которая может прыгать на высоту %d см:\n", dogName, jumpHeight);


        while (true) {
            System.out.printf("\nДаем команду взять барьер %.1f см:\n", targetBarrierHeight);
            var result = bella.takeBarrier(targetBarrierHeight);
            if(result == JumpStatus.SUCCESSFUL) {

                break;
            }
            else if (result == JumpStatus.NEED_TRAINING) {
                bella.train();
                bella.jump();
            }
            else
                break;
        }
        System.out.printf("\nВсего прыжков: %d\n", Dog.getTotalJumps());
    }
}
