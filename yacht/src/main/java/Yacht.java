import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Yacht {

    private final int score;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        var diceS = Arrays.stream(dice);
        Function<IntStream, Map<Integer, Long>> streamToMap = s -> s.boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        this.score = switch (yachtCategory) {
            case ONES -> diceS.filter(i -> i == 1).sum();
            case TWOS -> diceS.filter(i -> i == 2).sum();
            case THREES -> diceS.filter(i -> i == 3).sum();
            case FOURS -> diceS.filter(i -> i == 4).sum();
            case FIVES -> diceS.filter(i -> i == 5).sum();
            case SIXES -> diceS.filter(i -> i == 6).sum();
            case LITTLE_STRAIGHT -> diceS.sum() == 15 ? 30 : 0;
            case BIG_STRAIGHT -> diceS.sum() == 20 ? 30 : 0;
            case CHOICE -> diceS.sum();
            case YACHT -> diceS.distinct().count() == 1 ? 50 : 0;
            case FOUR_OF_A_KIND -> {
                var hm = streamToMap.apply(diceS);
                if (hm.size() > 2) yield 0;
                yield hm.entrySet().stream().filter(e -> e.getValue() > 3).findFirst().map(e -> e.getKey() * 4).orElse(0);
            }
            case FULL_HOUSE -> {
                var hm = streamToMap.apply(diceS);
                yield (hm.size() != 2 || !hm.containsValue(3L)) ? 0 : Arrays.stream(dice).sum();
            }
        };
    }

    int score() {
        return score;
    }
}
