import java.util.Arrays;

class ResistorColor {
    public enum Color{
        black(0),
        brown(1),
        red(2),
        orange(3),
        yellow(4),
        green(5),
        blue(6),
        violet(7),
        grey(8),
        white(9);

        int val;
        Color(int val){
            this.val = val;
        }
    }

    int colorCode(String color) {
        return Color.valueOf(color).ordinal();
    }

    String[] colors() {
        return Arrays.stream(Color.values()).map(Enum::name).toArray(String[]::new);
    }
}
