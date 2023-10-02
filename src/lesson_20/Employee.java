package lesson_20;

public class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Зарплата: " + salary);
    }

    public static void main(String[] args) {
        Employee emp = new Employee("Ivan", 30, 50000);
        emp.info();
    }
}
