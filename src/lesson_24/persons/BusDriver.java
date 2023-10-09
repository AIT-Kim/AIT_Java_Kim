package lesson_24.persons;
/**
 * 09.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class BusDriver extends Person {
    private String licenseNumber;
    private int id;

    public BusDriver(String name, int age, String licenseNumber, int id) {
        super(name, age);
        this.licenseNumber = licenseNumber;
        this.id = id;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void driverInfo() {
        System.out.println("Водитель: " + getName() + ", Возраст: " + getAge() + ", Номер лицензии: " + licenseNumber);
    }

    @Override
    public void info() {
        System.out.println("Информация о водителе:");
        super.info();
    }
}

