package lesson_29.triathleteext;
/**
 * 15.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Triathlete implements Swimmer, Runner {
    private int fatigueLevel = 0;
    private Shoe runningShoes;
    private Swimsuit swimsuit;

    public Triathlete(Shoe runningShoes, Swimsuit swimsuit) {
        this.runningShoes = runningShoes;
        this.swimsuit = swimsuit;
    }

    @Override
    public void swim(int distance) {
        fatigueLevel += distance;
        System.out.println("The triathlete swam " + distance + " meters using " + swimsuit.getBrand() + " swimsuit. Fatigue level: " + fatigueLevel);
    }

    @Override
    public void run(int distance) {
        fatigueLevel += 2 * distance; // Running might be more tiring than swimming
        System.out.println("The triathlete ran " + distance + " meters wearing " + runningShoes.getBrand() + " shoes. Fatigue level: " + fatigueLevel);
    }

    public void rest() {
        fatigueLevel = 0;
        System.out.println("The triathlete is resting and fatigue level is reset.");
    }
}

