class Scrabble {

    private final int score;

    Scrabble(String word) {
        this.score = word.chars().map(this::charToScore).sum();
    }

    private int charToScore(int chInt) {
        return switch (Character.toUpperCase(chInt)) {
            case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1;
            case 'D', 'G' -> 2;
            case 'B', 'C', 'M', 'P' -> 3;
            case 'F', 'H', 'V', 'W', 'Y' -> 4;
            case 'K'  -> 5;
            case 'J', 'X' -> 8;
            case 'Q', 'Z' -> 10;
            default -> throw new IllegalArgumentException();
        };
    }

    int getScore() {
        return score;
    }

}
