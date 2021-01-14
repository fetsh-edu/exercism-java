import java.util.stream.IntStream;

class NaturalNumber {

    private final int number;
    private final int aliquotSum;

    public NaturalNumber(int number) {
        if (number < 1) throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        this.number = number;
        this.aliquotSum = IntStream.rangeClosed(1, number / 2).filter(n -> number % n == 0).sum();
    }

    public Classification getClassification() {
        if (aliquotSum == number) return Classification.PERFECT;
        if (aliquotSum > number) return Classification.ABUNDANT;
        return Classification.DEFICIENT;
    }
}
