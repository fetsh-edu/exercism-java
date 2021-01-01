class RnaTranscription {

    String transcribe(String dnaStrand) {
        return dnaStrand.chars()
                .map(this::DNAToRNA)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    char DNAToRNA(int character) {
        return switch (character) {
            case 'G' -> 'C';
            case 'C' -> 'G';
            case 'T' -> 'A';
            case 'A' -> 'U';
            default -> (char) character;
        };
    }
}
