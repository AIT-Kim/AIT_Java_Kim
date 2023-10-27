package lesson_38.layers;

import lesson_38.layers.repositories.UsersRepository;
import lesson_38.layers.services.UsersService;
import lesson_38.layers.view.Menu;

public class Main {
    public static void main(String[] args) {
        UsersRepository usersRepository  = new UsersRepository();
        UsersService usersService = new UsersService(usersRepository);
        Menu menu = new Menu(usersService);

        menu.run();
    }
}
