package lesson_28;

public class Main {
    public static void main(String[] args) {

//        Table.Pair pair = new Table.Pair("Marsel", 29);

        Table table1 = new Table();
        table1.put("A", 10);
        table1.put("B", 20);
        table1.put("C", 30);

        Table table2 = new Table();
        table2.put("X", 100);
        table2.put("Y", 200);
        table2.put("Z", 400);

        // обращаемся к классу Printer, который вложен в класс Table
        // объявляем переменную типа Printer
        // присваиваем ссылку на объект класса Printer
        // мы обращаемся к объекту table, вызываем конструктор Printer-а из объекта table1
        // таким образом, printer1 будет "связан" с table1 (имеют друг на друга ссылки)
        Table.Printer printer1 = table1.new Printer("HI:"); // создаю printer1 на основе объекта table1
        Table.Printer printer2 = table2.new Printer("BYE:"); // создаю printer2 на основе объекта table2

        printer1.print(); // printer1 печатает содержимое table1
        printer2.print(); // printer2 печатает содержимое table2
    }
}
