package lesson_25.computer_and_components;

// Базовый класс для компонентов
public class Component {
    protected String brand;
    protected String model;

    public Component(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Бренд: " + brand + ", Модель: " + model;
    }
}
