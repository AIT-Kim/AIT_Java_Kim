package lesson_27.task1;
/**
 * 12.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
/**
 Создайте абстрактный класс GameCharacter, который представляет базовый класс для игровых персонажей.
 Определите абстрактный метод attack(), который будет различаться для разных типов персонажей
 (например, воин атакует мечом, а маг использует магические заклинания).
 Создайте несколько конкретных подклассов, представляющих разные типы персонажей, такие как Warrior, Mage, Archer, и т. д.
 Переопределите метод attack() для каждого класса. Создайте массив из игровых персонажей разных типов.
 Вызовите у каждого метод attack() в цикле.
 */
public class Main {
    public static void main(String[] args) {
        GameCharacter[] characters = {
                new Warrior("Baldric"),
                new Mage("Merlin"),
                new Archer("Robin"),
                new Warrior("Gideon")
        };

        // Example: Every character attacks the next one in the array.
        for (int i = 0; i < characters.length - 1; i++) {
            characters[i].attack(characters[i + 1]);
        }
    }
}
