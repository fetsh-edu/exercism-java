import java.util.stream.Collectors;

public class PangramChecker {
    public boolean isPangram(String input) {
        return input.toLowerCase().chars().filter(Character::isAlphabetic)
                .boxed().collect(Collectors.toSet()).size() == 26;
    }
}
