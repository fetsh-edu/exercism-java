class Darts {

    int score;

    Darts(double x, double y) {
        score = scoreForRadius(Math.pow(x, 2) + Math.pow(y, 2));
    }

    int score() {
        return score;
    }

    int scoreForRadius(double r) {
        if (r > 100) return 0;
        if (r > 25) return 1;
        if (r > 1) return 5;
        return 10;
    }
}
