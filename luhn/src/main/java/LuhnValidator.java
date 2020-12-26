import java.util.stream.IntStream;

class LuhnValidator {

    boolean isValid(String candidate) {
        String finalCandidate = candidate.replaceAll("\\s+", "");
        if (!finalCandidate.matches("^\\d{2,}")) return false;
        return IntStream.range(0, finalCandidate.length())
                .map(i -> {
                    var result = Character.getNumericValue(finalCandidate.charAt(finalCandidate.length() - 1 - i ));
                    return (i % 2 == 0 || result == 9) ? result : (result * 2) % 9;
                })
                .sum() % 10 == 0;
    }
}
