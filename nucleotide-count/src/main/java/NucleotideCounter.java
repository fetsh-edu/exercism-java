import java.util.HashMap;
import java.util.Map;

class NucleotideCounter{
    HashMap<Character, Integer> nc = new HashMap<>(Map.of('A', 0, 'C', 0, 'G', 0, 'T', 0));
    NucleotideCounter(String dna){
        if(!dna.matches("[ACGT]*")) throw new IllegalArgumentException();
        dna.chars().forEach(c -> nc.merge((char) c, 1, Integer::sum));
    }
    Map<Character, Integer> nucleotideCounts(){
        return nc;
    }
}