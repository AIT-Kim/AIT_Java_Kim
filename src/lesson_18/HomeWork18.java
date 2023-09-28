package lesson_18;

/**
 * 28.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */


public class HomeWork18 {


    public static void main(String[] args) {
        System.out.println("Task 0: ");
        task0();

        System.out.println("Task 1: ");
        task1();
    }

    /**
     В резиновом массиве должны быть реализованы методы:

     Добавление элемента
     Вывести все значения в массиве в консоль
     Поиск элемента по значению
     Возвращение значения по индексу
     Текущее количество элементов в массиве
     Удаление элемента по индексу
     Добавление нескольких элементов (в качестве аргументов передает последовательность значений)
     Конструктор, принимающий в себя обычный массив и создающий RubberArray с такими де значениями
     Удаление элемента по значению
     Замена значения по индексу (есть индекс и новое значение)
     Замена значения по значению (есть старое и новое значение)
     */
    private static void task0() {
        // Создаем CatArray
        CatArray myCats = new CatArray(new String[]{"Васька", "Мурзик", "Пушок"});
        System.out.println("Исходный список котиков:");
        myCats.displayCats();

        // Добавление котика
        myCats.addCat("Барсик");
        System.out.println("\nПосле добавления Барсика:");
        myCats.displayCats();

        // Поиск котика по имени
        int index = myCats.indexOfCat("Мурзик");
        System.out.println("\nИндекс котика Мурзик: " + index);

        // Получение имени котика по индексу
        String catNameAtIndex = myCats.getCat(2);
        System.out.println("Котик под индексом 2: " + catNameAtIndex);

        // Текущее количество котиков
        System.out.println("Всего котиков: " + myCats.catCount());

        // Удаление котика по индексу
        myCats.removeCat(1);
        System.out.println("\nПосле удаления котика под индексом 1:");
        myCats.displayCats();

        // Добавление нескольких котиков
        myCats.addCats("Снежок", "Тигр", "Леопард");
        System.out.println("\nПосле добавления трех новых котиков:");
        myCats.displayCats();

        // Удаление котика по имени
        myCats.removeCatByName("Тигр");
        System.out.println("\nПосле удаления котика по имени Тигр:");
        myCats.displayCats();

        // Замена имени котика по индексу
        myCats.replaceCatName(2, "Лео");
        System.out.println("\nПосле замены имени котика под индексом 2:");
        myCats.displayCats();

        // Замена имени одного котика на другое
        myCats.replaceCatName("Лео", "Симба");
        System.out.println("\nПосле замены имени Лео на Симба:");
        myCats.displayCats();
    }

    /**
     * Написать класс Собака. Собака должна иметь имя и высоту прыжка Должна уметь прыгать и должна уметь тренироваться.
     * За каждую тренировку высота прыжка увеличивается на 10 сантиметров Максимальная высота,
     * которую может натренировать собака не может быть больше, чем 2 раза высоту первоначального прыжка.
     *
     * Также должен быть метод взять барьер. В параметрах метод принимает высоту прыжка.
     * Если собака в состоянии преодолеть этот барьер - прыгает.
     * Если не в состоянии, нужно проверить помогут ли тренировки (будет ли данная собака в принципе в состоянии взять барьер).
     * Если да -> идем тренироваться -> берет барьер
     */
    private static void task1() {
        int jumpHeight = 30;
        String dogName = "Белла";
        Dog bella = new Dog(dogName, jumpHeight);
        double targetBarrierHeight = 60;

        System.out.printf("\nСоздана собака %s, которая может прыгать на высоту %d см:\n", dogName, jumpHeight);


        while (true) {
            System.out.printf("\nДаем команду взять барьер %.1f см:\n", targetBarrierHeight);
            var result = bella.takeBarrier(targetBarrierHeight);
            if(result == JumpStatus.SUCCESSFUL) {

                break;
            }
            else if (result == JumpStatus.NEED_TRAINING) {
                bella.train();
                bella.jump();
            }
            else
                break;
        }
    }


}


