package lesson_25.hierarchy;
/**
 * 09.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

// иерархия: Животные

public class Animal {
    String species;

    public Animal(String species) {
        this.species = species;
    }

    public String info() {
        return "Это животное: " + species;
    }
}




