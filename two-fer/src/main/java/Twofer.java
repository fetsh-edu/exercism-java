import java.util.Objects;

public class Twofer {
    public String twofer(String name) {
        return String.format("One for %s, one for me.", Objects.requireNonNullElse(name, "you"));
    }
}
