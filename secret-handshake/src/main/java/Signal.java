enum Signal {

    WINK, DOUBLE_BLINK, CLOSE_YOUR_EYES, JUMP;

    public static Signal ofInt(int n) {
        return switch (n) {
            case 1 -> WINK;
            case 2 -> DOUBLE_BLINK;
            case 4 -> CLOSE_YOUR_EYES;
            case 8 -> JUMP;
            default -> throw new IllegalArgumentException();
        };
    }
}
