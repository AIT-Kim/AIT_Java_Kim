package lesson_17;

/**
 * 27.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

// Класс "Светильник"
public class Lamp {
    private boolean isOn;
    
    public Lamp() {
        this.isOn = false;
    }

    // Включить лампу
    public void turnOn() {
        if(!isOn) {
            isOn = true;
            System.out.println("Лампа включена!");
        } else {
            System.out.println("Лампа уже включена.");
        }
    }

    // Выключить лампу
    public void turnOff() {
        if(isOn) {
            isOn = false;
            System.out.println("Лампа выключена!");
        } else {
            System.out.println("Лампа уже выключена.");
        }
    }

    // Проверить состояние лампы
    public boolean isLampOn() {
        return isOn;
    }
}