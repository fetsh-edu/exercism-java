import java.util.stream.Collectors;

class IsogramChecker {
    boolean isIsogram(String phrase) {
        var preparedPhrase = phrase.toLowerCase().replaceAll("-|\\s+", "");
        return preparedPhrase.chars().boxed().collect(Collectors.toSet()).size() == preparedPhrase.length();
    }
}
