class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        return (int) Math.pow((input * (input + 1) / 2D ), 2);
    }

    int computeSumOfSquaresTo(int input) {
        return input * (input + 1) * (2 * input + 1) / 6;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
