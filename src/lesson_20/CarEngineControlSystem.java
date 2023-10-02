package lesson_20;

/**
 * 02.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class CarEngineControlSystem {
    private boolean isEngineRunning;
    private double rpm;
    private double temperature;
    private double fuelLevel;
    private Thread fuelConsumptionThread;
    private Thread temperatureThread;

    public CarEngineControlSystem() {
        this.isEngineRunning = false;
        this.rpm = 0;
        this.temperature = 20;
        this.fuelLevel = 50;
    }

    public void startEngine() {
        if (!isEngineRunning && fuelLevel > 0) {
            isEngineRunning = true;
            rpm = 800;
            temperature = 20;
            System.out.println("Двигатель запущен.");

            fuelConsumptionThread = new Thread(() -> {
                while (isEngineRunning && fuelLevel > 0) {
                    try {
                        fuelLevel -= calculateFuelConsumption();
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (fuelLevel <= 0) {
                    stopEngine();
                    System.out.println("Топливо закончилось. Двигатель остановлен.");
                }
            });
            fuelConsumptionThread.start();

            temperatureThread = new Thread(() -> {
                while (isEngineRunning) {
                    try {
                        temperature += (rpm - 800) / 10000;
                        if (temperature > 95) temperature = 95;
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            temperatureThread.start();

        } else if (fuelLevel <= 0) {
            System.out.println("Недостаточно топлива для запуска двигателя.");
        } else {
            System.out.println("Двигатель уже запущен.");
        }
    }

    public void stopEngine() {
        if (isEngineRunning) {
            isEngineRunning = false;
            rpm = 0;
            System.out.println("Двигатель остановлен.");
            if (fuelConsumptionThread != null && fuelConsumptionThread.isAlive()) {
                fuelConsumptionThread.interrupt();
            }
        } else {
            System.out.println("Двигатель уже остановлен.");
        }
    }

    public void increaseRPM(double increaseBy) {
        if (isEngineRunning) {
            rpm += increaseBy;
            System.out.println("Обороты увеличены. Текущие обороты: " + rpm);
        } else {
            System.out.println("Невозможно увеличить обороты. Двигатель не запущен.");
        }
    }

    public void decreaseRPM(double decreaseBy) {
        if (isEngineRunning && rpm - decreaseBy >= 800) {
            rpm -= decreaseBy;
            System.out.println("Обороты уменьшены. Текущие обороты: " + rpm);
        } else if (rpm - decreaseBy < 800) {
            System.out.println("Невозможно уменьшить обороты ниже холостого хода.");
        } else {
            System.out.println("Невозможно уменьшить обороты. Двигатель не запущен.");
        }
    }

    private double calculateFuelConsumption() {
        double baseConsumption = 0.02;
        double rpmConsumption = (rpm - 800) / 10000 * 0.05;

        double totalConsumption = baseConsumption + rpmConsumption;
        return Math.min(totalConsumption, fuelLevel);
    }




    public void info() {
        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│       Информация о двигателе    │");
        System.out.println("├─────────────────┬───────────────┤");
        System.out.printf("│ Работает        │ %-13s │\n", (isEngineRunning ? "Да" : "Нет"));
        System.out.printf("│ Обороты (RPM)   │ %-13.2f │\n", rpm);
        System.out.printf("│ Температура (°C)│ %-13.2f │\n", temperature);
        System.out.printf("│ Уровень топлива │ %-13.2f │\n", fuelLevel);
        System.out.println("└─────────────────┴───────────────┘");
    }


    public boolean isEngineRunning() {
        return isEngineRunning;
    }

    public double getRpm() {
        return rpm;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        if (fuelLevel >= 0) {
            this.fuelLevel = fuelLevel;
        } else {
            System.out.println("Уровень топлива не может быть отрицательным.");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        CarEngineControlSystem carEngine = new CarEngineControlSystem();
        carEngine.setFuelLevel(3);

        System.out.println("Запускаем двигатель.");
        carEngine.startEngine();
        carEngine.info();
        Thread.sleep(2000);

        for (int i = 0; i < 5; i++) {
            carEngine.increaseRPM(500 + 200 * i);
            System.out.println("Увеличиваем скорость...");
            carEngine.info();
            Thread.sleep(2000);
        }

        for (int i = 0; i < 3; i++) {
            carEngine.decreaseRPM(600);
            System.out.println("Уменьшаем скорость...");
            carEngine.info();
            Thread.sleep(2000);
        }

        while (carEngine.isEngineRunning()) {
            System.out.println("Едем...");
            carEngine.info();
            Thread.sleep(2000);
        }

        System.out.println("Поездка завершена.");
        carEngine.info();
    }
}
