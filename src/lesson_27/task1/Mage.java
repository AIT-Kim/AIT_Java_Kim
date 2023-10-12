package lesson_27.task1;
/**
 * 12.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Mage extends GameCharacter {
    private int mana;

    public Mage(String name) {
        super(name, 80, 20);
        this.mana = 50;
    }

    @Override
    public void attack(GameCharacter target) {
        if (mana >= 10) {
            System.out.println(name + " casts a fireball at " + target.name);
            target.takeDamage(attackPower);
            mana -= 10;
        } else {
            System.out.println(name + " is out of mana and cannot attack!");
        }
    }
}

