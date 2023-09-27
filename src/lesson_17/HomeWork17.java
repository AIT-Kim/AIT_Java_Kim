package lesson_17;

/**
 * 27.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

public class HomeWork17 {
    public static void main(String[] args) {
        // "Книга"
        Book myBook = new Book("Программирование на Java", "Иван Иванов", 400);
        // Читаем страницу 100
        String contentOfPage100 = myBook.readPage(100);
        System.out.println("Содержимое страницы 100: " + contentOfPage100);

        // "Чашка кофе"
        CoffeeCup myCoffee = new CoffeeCup(300, 200, "Латте");
        // Делаем глоток кофе
        myCoffee.sip();
        System.out.println("Вы сделали глоток кофе. Осталось " + myCoffee.getCurrentAmount() + " мл.");

        // "Светильник"
        Lamp myLamp = new Lamp();
        myLamp.turnOn();
        if (myLamp.isLampOn()) {
            System.out.println("Лампа светит!");
        } else {
            System.out.println("В комнате темно.");
        }
        myLamp.turnOff();
    }
}
