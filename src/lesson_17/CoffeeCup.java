package lesson_17;

/**
 * 27.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

// Класс "Чашка кофе"
public class CoffeeCup {
    private int volume; // Объем чашки
    private int currentAmount; // Текущее количество кофе в чашке
    private String type; // Тип кофе (латте, эспрессо и т.д.)

    public CoffeeCup(int volume, int currentAmount, String type) {
        this.volume = volume;
        this.currentAmount = currentAmount;
        this.type = type;
    }

    // Cделать глоток
    public void sip() {
        if (currentAmount > 10) {
            currentAmount -= 10;
        } else if (currentAmount > 0) {
            System.out.println("Ваш последний глоток!");
            currentAmount = 0;
        } else {
            System.out.println("Чашка пуста!");
        }
    }


    public int getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(int amount) {
        this.currentAmount = amount;
    }

}