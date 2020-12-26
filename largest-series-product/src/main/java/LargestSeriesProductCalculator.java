import java.util.Arrays;
import java.util.stream.IntStream;

class LargestSeriesProductCalculator {

    String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        if (!inputNumber.matches("\\d*")) throw new IllegalArgumentException("String to search may only contain digits.");
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if(numberOfDigits > inputNumber.length()) throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        if(numberOfDigits < 0) throw new IllegalArgumentException("Series length must be non-negative.");
        if (numberOfDigits == 0) return 1;
        return IntStream.iterate(0, i -> i <= inputNumber.length() - numberOfDigits, i -> i + 1)
                .mapToObj(i -> inputNumber.substring(i, Math.min(i + numberOfDigits, inputNumber.length())))
                .mapToInt(s -> Arrays.stream(s.split("")).mapToInt(Integer::parseInt).reduce(1, (a, b) -> a * b))
                .summaryStatistics().getMax();
    }
}
