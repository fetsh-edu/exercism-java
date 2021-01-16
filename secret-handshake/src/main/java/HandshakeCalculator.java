import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class HandshakeCalculator {

    List<Signal> calculateHandshake(final int n) {
        var list = (n & 19) == 19 ? List.of(8,4,2,1) : List.of(1,2,4,8);
        return list.stream().filter(i -> (n & i) == i).map(Signal::ofInt).collect(Collectors.toList());
    }

}
