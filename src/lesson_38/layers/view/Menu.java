package lesson_38.layers.view;

import lesson_38.layers.models.User;
import lesson_38.layers.services.UsersService;

import java.util.Scanner;

public class Menu { // слой представления

    private UsersService usersService; // ссылка на сервис, по факту - слой представления вызывает методы слоя сервисов

    public Menu(UsersService usersService) { // конструктор, который позволяет положить конкретный сервис в наше меню
        this.usersService = usersService;
    }

    public void run() { // основной метод нашего слоя представления, запускают работу меню
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // выводим команды меню
            System.out.println("1. Зарегистрировать пользователя");
            System.out.println("2. Показать всех пользователей");
            System.out.println("0. Выход");
            // ожидаем, что пользователь введет какую-либо команду
            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) { // в зависимости от команды, которую вы ввели, будет работать определенный case
                case 0: {
                    System.out.println("Выходим из программы...");
                    System.exit(0);
                }
                break;

                case 1: {
                    // ждем, пока введут имя
                    String firstName = scanner.nextLine();
                    // ждем, пока введут фамилию
                    String lastName = scanner.nextLine();
                    // ждем, пока введут email
                    String email = scanner.nextLine();
                    // ждем, пока введут пароль
                    String password = scanner.nextLine();
                    // все данные, которые мы собрали, передаем в сервис-слой, а конкретно в метод - register
                    usersService.register(firstName, lastName, email, password);
                }
                break; // благодаря этому break мы переходим в начало цикла

                case 2: { // вывод списка всех пользователей
                    User[] users = usersService.getAllUsers(); // запрашиваю всех пользователей у сервис-слоя

                    for (int i = 0; i < users.length; i++) { // печатаю о них то, что мне нужно
                        System.out.println(users[i].getFirstName() + " " + users[i].getLastName());
                    }
                } break;
            }

        }

    }
}