import java.util.Arrays;
import java.util.OptionalInt;

class Acronym {

    private final String acronym;

    Acronym(String phrase) {
        this.acronym = Arrays.stream(phrase.split("[\\s-]+"))
                .map(s -> s.chars().filter(Character::isAlphabetic).findFirst())
                .filter(OptionalInt::isPresent)
                .map(o -> Character.toUpperCase((char) o.getAsInt()))
                .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append)
                .toString();
    }

    String get() {
        return acronym;
    }

}
