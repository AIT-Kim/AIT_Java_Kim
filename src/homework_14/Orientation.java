package homework_14;
/**
 * 23.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public enum Orientation {
    HORIZONTAL,
    VERTICAL;

    public static Orientation fromString(String str) {
        switch (str.toLowerCase()) {
            case "h":
            case "horizontal":
                return HORIZONTAL;
            case "v":
            case "vertical":
                return VERTICAL;
            default:
                throw new IllegalArgumentException("Invalid orientation input");
        }
    }
}

