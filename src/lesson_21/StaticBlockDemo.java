package lesson_21;
/**
 * 04.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class StaticBlockDemo {

    private static String[] colorArray;
    private static final int COUNT = 5;
    private static int[] numbers = new int[COUNT];
    private String name = "SampleString";
    private int size = 5;

    static {
        System.out.println("First static initialization block.");
        colorArray = new String[3];
        colorArray[0] = "Blue";
        colorArray[1] = "Yellow";
        colorArray[2] = "Red";
    }

    {
        System.out.println("Instance initialization block.");
        this.name = "AnotherString";
        this.size = 10;
    }

    static {
        System.out.println("Second static initialization block.");
        colorArray[0] = "Gray";
    }

    public StaticBlockDemo(String name, int size) {
        System.out.println("Constructor invoked.");
        this.name = name;
        this.size = size;
    }

    public void modifyColors(String firstColor, String secondColor) {
        colorArray[0] = firstColor;
        colorArray[1] = secondColor;
    }

    public static void displayColors() {
        for (String color : colorArray) {
            System.out.print(color + "; ");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {

        StaticBlockDemo instanceOne = new StaticBlockDemo("FirstInstance", 5);
        StaticBlockDemo.displayColors();

        instanceOne.modifyColors("Black", "White");
        StaticBlockDemo.displayColors();

        StaticBlockDemo instanceTwo = new StaticBlockDemo("SecondInstance", 6);
        StaticBlockDemo.displayColors();
    }
}
