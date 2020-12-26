class RaindropConverter {

    String convert(int number) {
        if (number % (3*5*7) == 0) return "PlingPlangPlong";
        if (number % (5*7) == 0) return "PlangPlong";
        if (number % (3*7) == 0) return "PlingPlong";
        if (number % (3*5) == 0) return "PlingPlang";
        if (number % 3 == 0) return "Pling";
        if (number % 5 == 0) return "Plang";
        if (number % 7 == 0) return "Plong";
        return Integer.toString(number);
    }
}
