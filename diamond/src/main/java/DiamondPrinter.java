import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DiamondPrinter {
    List<String> printToList(char a) {
        return IntStream.concat(IntStream.rangeClosed('A', a), IntStream.iterate(a - 1, i -> i >= 'A', i -> i - 1))
                .mapToObj(c -> { StringBuilder line = new StringBuilder(" ".repeat((a - 'A') * 2 + 1));
                    line.setCharAt(a - c, (char) c); line.setCharAt(line.length() - 1 - (a - c), (char) c);
                    return line.toString();
                }).collect(Collectors.toList());
    }
}