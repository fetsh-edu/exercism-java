import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        return IntStream.iterate(0, i -> i < rnaSequence.length(), i -> i + 3)
                .mapToObj(i -> rnaSequence.substring(i, Math.min(i + 3, rnaSequence.length())))
                .map(this::codonToProtein)
                .takeWhile(Objects::nonNull)
                .collect(Collectors.toList());
    }

    String codonToProtein(String codon){
        return switch (codon) {
            case "AUG" -> "Methionine";
            case "UUU", "UUC" -> "Phenylalanine";
            case "UUA", "UUG" -> "Leucine";
            case "UCU", "UCC", "UCA", "UCG" -> "Serine";
            case "UAU", "UAC" -> "Tyrosine";
            case "UGU", "UGC" -> "Cysteine";
            case "UGG" -> "Tryptophan";
            case "UAA", "UAG", "UGA" -> null;
            default -> throw new IllegalArgumentException("Illegal codon: " + codon);
        };
    }
}
