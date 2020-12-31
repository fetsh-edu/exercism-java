import java.util.regex.Pattern;

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        return Pattern.compile("").splitAsStream(String.valueOf(numberToCheck))
                .mapToDouble(s -> Math.pow(Double.parseDouble(s), String.valueOf(numberToCheck).length()))
                .sum() == numberToCheck;
    }
}
