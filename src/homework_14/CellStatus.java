package homework_14;
/**
 * 23.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public enum CellStatus {
    UNKNOWN("."),     // неизвестное состояние или пустая ячейка
    SHIP("S"),        // корабль
    HIT("X"),         // попадание
    MISS("O"),        // промах
    ALREADY_HIT("!"), // уже пораженный
    DESTROYED("K"),
    SHIP_ALREADY_HIT("L"); // попали в корабль, в который уже стреляли ранее, но не в эту конкретную ячейку

    private final String representation;

    CellStatus(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }
}
