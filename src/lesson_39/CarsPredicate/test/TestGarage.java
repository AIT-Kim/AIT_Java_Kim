package lesson_39.CarsPredicate.test;

import lesson_39.CarsPredicate.lib.MyList;
import lesson_39.CarsPredicate.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import lesson_39.CarsPredicate.repository.RepositoryCars;
import lesson_39.CarsPredicate.service.ServiceCars;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestGarage {
    private final ServiceCars service;

    public TestGarage() {
        RepositoryCars repository = new RepositoryCars();
        this.service = new ServiceCars(repository);
        // this.service = new ServiceCars();
    }

    @ParameterizedTest
    @MethodSource("dataTestValidCars")
    void testAddValidCar(String model, int year, double price){
        System.out.println(model + " | " + year + " | "+ price );
        MyList<Car> cars = service.getAllCars();
        int size = cars.size();
        Car car = service.addCar(model, year, price);
        // cars = service.getAllCars();
        assertNotNull(car);
        assertEquals(size + 1, cars.size());
        assertTrue(cars.contains(car));
    }

    static Stream<Arguments> dataTestValidCars() {
        return  Stream.of(
                Arguments.of("Skoda", 2023, 5000),
                Arguments.of("Ford", 2023, 42000)
        );
    }

    @Test
    void testPredicate() {
        MyList<Car> cars = service.getCarsYearGreat(2021);
        for (Car car : cars) {
            System.out.println(car);
        }

        MyList<Car> cars1 = service.getCarsYearLess(2030);
        System.out.println(cars1);

        MyList<Car> cars2 = service.getCarsByPriceAndYear(2022, 40000);
        System.out.println(cars2);
    }

}