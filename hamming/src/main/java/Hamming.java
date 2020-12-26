import java.util.stream.IntStream;

public class Hamming {

    private final int hummingDistance;

    public Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.isEmpty() && !rightStrand.isEmpty()) throw new IllegalArgumentException("left strand must not be empty.");
        if(rightStrand.isEmpty() && !leftStrand.isEmpty()) throw new IllegalArgumentException("right strand must not be empty.");
        if(leftStrand.length() != rightStrand.length()) throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        hummingDistance = (int) IntStream.range(0, leftStrand.length())
                .filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i))
                .count();
    }

    public int getHammingDistance() {
        return hummingDistance;
    }
}
