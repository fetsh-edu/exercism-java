class ResistorColorDuo {
    public enum Color{
        black,
        brown,
        red,
        orange,
        yellow,
        green,
        blue,
        violet,
        grey,
        white;
    }

    int value(String[] colors) {
        return Color.valueOf(colors[0]).ordinal() * 10 + Color.valueOf(colors[1]).ordinal();
    }
}
