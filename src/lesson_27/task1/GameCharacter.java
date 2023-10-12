package lesson_27.task1;
/**
 * 12.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public abstract class GameCharacter {
    protected String name;
    protected int health;
    protected int attackPower;

    public GameCharacter(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public abstract void attack(GameCharacter target);

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(name + " took " + damage + " damage. Remaining health: " + health);
    }
}

