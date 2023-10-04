package lesson_21;
/**
 * 04.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
/**
 HomeWork
 Добавить в Employee уникальный идентификатор каждому сотруднику
 */
public class Employee {
    private String name;
    private int age;
    private double salary;
    private int id;  // Уникальный идентификатор сотрудника

    private static int idCounter = 0;  // Счетчик для генерации уникальных ID

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.id = idCounter++;  // Присвоение уникального ID и увеличение счетчика
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0) {  // Простая проверка на корректность возраста
            this.age = age;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary >= 0) {  // Зарплата не может быть отрицательной
            this.salary = salary;
        }
    }

    public void info() {
        System.out.println("ID: " + id);
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Зарплата: " + salary);
    }

    public static void main(String[] args) {
        Employee emp = new Employee("Ivan", 30, 50000);
        emp.info();

        Employee emp2 = new Employee("Anna", 28, 60000);
        emp2.info();
    }
}
