import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Anagram{

    String word;
    int[] wordSorted;

    public Anagram(String word) {
        this.word = word.toLowerCase();
        this.wordSorted = this.word.chars().sorted().toArray();
    }
    List<String> match(List<String> matches){
        return matches.stream()
                .filter(s -> !s.equalsIgnoreCase(word))
                .filter(s ->  Arrays.equals(s.toLowerCase().chars().sorted().toArray(), wordSorted))
                .collect(Collectors.toList());
    }
}