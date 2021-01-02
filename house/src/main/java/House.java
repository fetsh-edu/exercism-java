import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class House{
    List<String> content = List.of(
            "the horse and the hound and the horn that belonged to ",
            "the farmer sowing his corn that kept ",
            "the rooster that crowed in the morn that woke ",
            "the priest all shaven and shorn that married ",
            "the man all tattered and torn that kissed ",
            "the maiden all forlorn that milked ",
            "the cow with the crumpled horn that tossed ",
            "the dog that worried ",
            "the cat that killed ",
            "the rat that ate ",
            "the malt that lay in ",
            "the house that Jack built."
    );

    String verse(int n){
        return "This is ".concat(
                IntStream.range(content.size() - n, content.size())
                        .mapToObj(content::get)
                        .collect(Collectors.joining())
        );
    }
    String verses(int n1, int n2){
        return IntStream.rangeClosed(n1, n2)
                .mapToObj(this::verse)
                .collect(Collectors.joining("\n"));
    }
    String sing(){
        return verses(1, content.size());
    }
}