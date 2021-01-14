record Queen(int x, int y){
    public Queen {
        if (x < 0) throw new IllegalArgumentException("Queen position must have positive row.");
        if (x > 7) throw new IllegalArgumentException("Queen position must have row <= 7.");
        if (y < 0) throw new IllegalArgumentException("Queen position must have positive column.");
        if (y > 7) throw new IllegalArgumentException("Queen position must have column <= 7.");
    }
}

public class QueenAttackCalculator {

    private final boolean canQueensAttackOneAnother;

    public QueenAttackCalculator(Queen queen1, Queen queen2) {
        if ((queen1 == null) || (queen2 == null)) throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        if (queen1.equals(queen2)) throw new IllegalArgumentException("Queens cannot occupy the same position.");
        this.canQueensAttackOneAnother = canQueensAttackOneAnother(queen1, queen2);
    }

    public boolean canQueensAttackOneAnother() {
        return canQueensAttackOneAnother;
    }

    private boolean canQueensAttackOneAnother(final Queen queen1, final Queen queen2) {
        return queen1.x() == queen2.x()
                || queen1.y() == queen2.y()
                || Math.abs(queen1.x() - queen2.x()) == Math.abs(queen1.y() - queen2.y());
    }
}