package lesson_20;

public class Main20 {
    public static void main(String[] args) {
        Cat20 felineInstance = new Cat20("Gennadiy", 4, 10);

        felineInstance.modifyAge(100);  // в сеттере проверка не пройдена
        felineInstance.modifyAge(5);    // прошло проверку
        felineInstance.modifyWeight(20);

        System.out.println("Имя: " + felineInstance.obtainName());
        System.out.println("Возраст: " + felineInstance.obtainAge());
        System.out.println("Масса: " + felineInstance.obtainWeight());
    }
}