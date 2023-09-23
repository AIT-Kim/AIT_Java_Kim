package homework_14;
/**
 * 23.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public enum Difficulty {
    EASY,
    NORMAL,
    HARD;

    @Override
    public String toString() {
        switch(this) {
            case EASY: return "Easy";
            case NORMAL: return "Normal";
            case HARD: return "Hard";
            default: throw new IllegalArgumentException();
        }
    }
}
