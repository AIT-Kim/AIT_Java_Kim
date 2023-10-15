package lesson_29.triathleteext;
/**
 * 15.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Main {
    public static void main(String[] args) {
        Shoe nikeShoes = new Shoe("Nike");
        Swimsuit adidasSwimsuit = new Swimsuit("Adidas");

        Triathlete triathlete = new Triathlete(nikeShoes, adidasSwimsuit);

        triathlete.run(5000); // 5 kilometers
        triathlete.swim(1000); // 1 kilometer
        triathlete.rest();
        triathlete.run(10000); // 10 kilometers
    }
}
