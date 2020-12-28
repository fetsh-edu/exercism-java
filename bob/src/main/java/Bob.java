class Bob {
    String hey(String some){
        some = some.strip();
        if(some.isEmpty()) return "Fine. Be that way!";
        return some.endsWith("?")
                ? yell(some)
                    ? "Calm down, I know what I'm doing!"
                    : "Sure."
                : yell(some)
                    ? "Whoa, chill out!"
                    : "Whatever.";
    }

    boolean yell(String word){
        return word.toUpperCase().equals(word) && !word.toLowerCase().equals(word);
    }
}