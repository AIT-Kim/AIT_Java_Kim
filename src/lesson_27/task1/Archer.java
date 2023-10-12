package lesson_27.task1;
/**
 * 12.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Archer extends GameCharacter {
    private int arrows;

    public Archer(String name) {
        super(name, 90, 15);
        this.arrows = 20;
    }

    @Override
    public void attack(GameCharacter target) {
        if (arrows > 0) {
            System.out.println(name + " shoots an arrow at " + target.name);
            target.takeDamage(attackPower);
            arrows--;
        } else {
            System.out.println(name + " has no arrows left!");
        }
    }
}

