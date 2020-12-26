import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DiamondPrinter {

    List<String> printToList(char a) {
        return IntStream.concat(
                IntStream.rangeClosed('A', a),
                IntStream.iterate(a - 1, i -> i >= 'A', i -> i - 1)
        ).mapToObj(c -> {
            if (a == 'A') return "A";
            if (c == 'A') return " ".repeat(a - c).concat("A").concat(" ".repeat(a - c));
            return " ".repeat(a - c).concat(Character.toString(c)).concat(" ".repeat((c - 'A') * 2 - 1)).concat(Character.toString(c)).concat(" ".repeat(a - c));
        }).collect(Collectors.toList());
    }
}
