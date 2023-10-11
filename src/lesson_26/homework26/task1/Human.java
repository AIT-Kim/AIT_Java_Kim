package lesson_26.homework26.task1;
/**
 * 11.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public abstract class Human {

    private final int speed;
    private final int restTime;

    protected Human(int speed, int restTime) {
        this.speed = speed;
        this.restTime = restTime;
    }

    public void run() {
        System.out.println(getClass().getSimpleName() + " runs at a speed of " + speed + " km/h.");
        rest();
    }

    private void rest() {
        System.out.println("Needs rest after running for " + restTime + " minutes.");
    }
}

