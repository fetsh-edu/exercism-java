import java.util.Arrays;
import java.util.stream.IntStream;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        if (stringToVerify.isEmpty()) return false;

        var XPlace = stringToVerify.indexOf("X");
        if (XPlace > -1 && XPlace < stringToVerify.length() - 1) return false;

        var values = Arrays.stream(stringToVerify.replaceAll("[^0-9X]", "").split(""))
                .map(c -> c.equals("X") ? "10" : c)
                .mapToInt(Integer::parseInt)
                .toArray();
        if (values.length != 10) return false;

        return IntStream.iterate(values.length, i -> i >= 1, i -> i = i - 1)
                .map(i -> i * values[values.length - i])
                .sum() % 11 == 0;
    }
}
