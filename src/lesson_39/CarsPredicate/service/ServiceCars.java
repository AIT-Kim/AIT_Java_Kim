package lesson_39.CarsPredicate.service;

import lesson_39.CarsPredicate.interfaces.InterfaceServiceCars;
import lesson_39.CarsPredicate.lib.MyArrayList;
import lesson_39.CarsPredicate.lib.MyList;
import lesson_39.CarsPredicate.model.Car;
import lesson_39.CarsPredicate.repository.RepositoryCars;

import java.util.function.Predicate;

public class ServiceCars implements InterfaceServiceCars<Car> {

    private final RepositoryCars repositoryCars;

    public ServiceCars() {
        repositoryCars = new RepositoryCars();
    }

    public ServiceCars(RepositoryCars repositoryCars) {
        this.repositoryCars = repositoryCars;
    }

    /*
    Добавление машины
     */

    @Override
    public Car addCar(String model, int year, double price) {
        // код проверки входящих аргументов
        // если параметры не прошли проверку - возвращаем null
        if (year < 1900) return null;
        Car car = new Car(model, year, price);
        repositoryCars.save(car);
        return car;
    }

    public MyList<Car> getAllCars() {
        return repositoryCars.getAllCars();
    }

    public MyList<Car> getCarsYearGreat(int year){
        Predicate<Car> carPredicate = new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getYear() > year;
            }
        };

        return repositoryCars.getCarsByPredicate(carPredicate);

//        MyList<Car> cars = repositoryCars.getAllCars();
//        MyList<Car> result = new MyArrayList<>();
//        for (Car car : cars) {
//            if (car.getYear() > year){
//                result.add(car);
//            }
//        }
//
//        return result;
    }

    public MyList<Car> getCarsYearLess(int year) {

        return repositoryCars.getCarsByPredicate(car -> car.getYear() < year);

//        MyList<Car> cars = repositoryCars.getAllCars();
//        MyList<Car> result = new MyArrayList<>();
//        for (Car car : cars) {
//            if (car.getYear() < year){
//                result.add(car);
//            }
//        }
//
//        return result;
    }


    public MyList<Car> getCarsPriceGreatAt(double price){
        MyList<Car> cars = repositoryCars.getAllCars();
        MyList<Car> result = new MyArrayList<>();
        for (Car car : cars) {
            if (car.getPrice() > price){
                result.add(car);
            }
        }

        return result;
    }

    MyList<Car> getCarsPriceLessAt(double price){
        MyList<Car> cars = repositoryCars.getAllCars();
        MyList<Car> result = new MyArrayList<>();
        for (Car car : cars) {
            if (car.getPrice() < price){
                result.add(car);
            }
        }

        return result;
    }

    MyList<Car> getCarsModelContains(String string){

        return repositoryCars.getCarsByPredicate(car -> car.getModel().contains(string));
//        MyList<Car> cars = repositoryCars.getAllCars();
//        MyList<Car> result = new MyArrayList<>();
//        for (Car car : cars) {
//            if (car.getModel().contains(string)){
//                result.add(car);
//            }
//        }
//
//        return result;
    }

    MyList<Car> getCarsModelStartAt(String startString){
        return repositoryCars.getCarsByPredicate((car -> car.getModel().startsWith(startString)));

//        MyList<Car> cars = repositoryCars.getAllCars();
//        MyList<Car> result = new MyArrayList<>();
//        for (Car car : cars) {
//            if (car.getModel().startsWith(startString)){
//                result.add(car);
//            }
//        }
//
//        return result;
    }

    public MyList<Car> getCarsByPriceAndYear(int year, double price){
        // моложе 2022 года и дешевле 40000
        Predicate<Car> pr1 = car -> car.getYear() < year;
        Predicate<Car> pr2 = car -> car.getPrice() < price;
        Predicate<Car> pr3 = car -> car.getModel().length() > 3;
        return repositoryCars.getCarsByPredicate((pr1.and(pr2)));
    }

}