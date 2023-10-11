package lesson_26.homework26.task1;
/**
 * 11.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
/**
 Напишите иерархию классов человек -> спортсмен-любитель - > спортсмен-профи У человека есть метод бежать.
 Обычный человек бежит со скоростью 10 км, любитель 15, профи - 25;

 Также у наших спортсменов есть необходимость в отдыхе. Человек нужен отдых после пробежки 15 минут, любитель 10, профи 5
 В методе бежать - вызвать метод, который будет выводить количество минут, необходимых для отдыха спортсменам
 */
public class Main {
    public static void main(String[] args) {
        Human[] runners = {
                new RegularHuman(),
                new AmateurAthlete(),
                new ProAthlete()
        };

        for (Human runner : runners) {
            runner.run();
            System.out.println();
        }
    }
}
