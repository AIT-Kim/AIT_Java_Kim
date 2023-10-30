package lesson_39.CarsPredicate.interfaces;

import lesson_39.CarsPredicate.model.Car;

public interface InterfaceServiceCars<T extends Car> {

    /*
    добавить новый автомобиль
    */

    T addCar(String model, int year, double price);

}