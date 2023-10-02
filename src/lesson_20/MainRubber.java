package lesson_20;

public class MainRubber {
    public static void main(String[] args) {
        RubberArray20 ra = new RubberArray20();

        ra.add(0, 1, 2, 3, 4, 5, 6);
        ra.add(100);

        System.out.println(ra.toString());
    }
}