import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Series{
    String string;

    Series(String string){
        this.string = string;
    }
    List<String> slices(int slice){
        if (slice < 1) throw new IllegalArgumentException("Slice size is too small.");
        if (slice > string.length()) throw new IllegalArgumentException("Slice size is too big.");
        return IntStream.rangeClosed(0, string.length() - slice).mapToObj(i -> string.substring(i, i + slice)).collect(Collectors.toList());
    }
}