package lesson_55.homework55;

/*
Дан список Employee.
Вычислите среднюю зарплату сотрудников в каждом отделе и найдите отдел с максимальной средней зарплатой.
 */

import lesson_55.streamsExample.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Petr", 2500, 25, "developer", "IT"),
                new Employee("Silvia", 1500, 22, "trainee", "IT"),
                new Employee("Stefan", 2500, 30, "PM", "IT"),
                new Employee("Olivia", 2700, 25, "manager", "Management"),
                new Employee("Sebastian", 3500, 25, "chef", "Management"),
                new Employee("Hanna", 1300, 25, "Cleaner", "Cleaning"),
                new Employee("John", 3200, 19, "chef", "IT")
        ));

        // группировка по отделам с вычислением средней зп
        Map<String, Double> averageSalaries = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(empl -> empl.getSalary())));

        // запись ссылкой на метод
        // .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        //Два варианта поиска "максимальной" пару ключ-значение с компаратором, сравнивающим средние зп по отделам
        Map.Entry<String, Double> maxAverage = averageSalaries.entrySet().stream()
                .max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
                .orElseThrow(() -> new NoSuchElementException("No department found"));

        //Вариант 2
        Optional<Map.Entry<String, Double>> maxAverageOptional2 = averageSalaries.entrySet().stream()
                .max(Map.Entry.comparingByValue());


        for (Map.Entry<String, Double> entry : averageSalaries.entrySet()){
            System.out.printf("%s: Средняя зп: %.2f\n", entry.getKey(), entry.getValue());
        }

        System.out.println("\nВариант 1:");
        System.out.printf("Отдел с максимальной средней зарплатой: %s (ср.зп: %.2f)\n", maxAverage.getKey(), maxAverage.getValue());
        System.out.println("======================\n");


        if (!maxAverageOptional2.isPresent()) {
            System.out.println("No department found");
        } else {
            System.out.println("Вариант 2:");
            System.out.printf("Отдел с максимальной средней зарплатой: %s (ср.зп: %.2f)", maxAverageOptional2.get().getKey(), maxAverageOptional2.get().getValue());
        }

    }
}