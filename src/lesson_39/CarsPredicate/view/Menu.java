package lesson_39.CarsPredicate.view;

import lesson_39.CarsPredicate.service.ServiceCars;

public class Menu {
    private final ServiceCars serviceCars;

    public Menu() {
        this.serviceCars = new ServiceCars();
    }

    public void run() {
        System.out.println("Start");

        while (true){
            showMenu();
        }
    }

    private void showMenu() {
        System.out.println("1. Список всех книг");
        System.out.println("0. Выход");
    }
}