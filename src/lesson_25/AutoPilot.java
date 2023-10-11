package lesson_25;
/**
 * 10.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class AutoPilot {
    private String version;

    public AutoPilot(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "{AutoPilot v" + version + "}";
    }

    public String getVersion() {
        return version;
    }

    public void updateVersion(String newVersion) {
        this.version = newVersion;
    }
}
