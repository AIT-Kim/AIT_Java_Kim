package lesson_27.task1;
/**
 * 12.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Warrior extends GameCharacter {
    public Warrior(String name) {
        super(name, 100, 25);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " swings sword at " + target.name);
        target.takeDamage(attackPower);
    }
}

