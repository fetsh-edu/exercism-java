import java.util.Map;
import java.util.TreeMap;

class RomanNumeral{
    String romanNumeral;
    private static final TreeMap<Integer, String> treemap = new TreeMap<>(
            Map.ofEntries(
                    Map.entry(1000, "M"),
                    Map.entry(900, "CM"),
                    Map.entry(500, "D"),
                    Map.entry(400, "CD"),
                    Map.entry(100, "C"),
                    Map.entry(90, "XC"),
                    Map.entry(50, "L"),
                    Map.entry(40, "XL"),
                    Map.entry(10, "X"),
                    Map.entry(9, "IX"),
                    Map.entry(5, "V"),
                    Map.entry(4, "IV"),
                    Map.entry(1, "I")
            )
    );

    RomanNumeral(int number) {
        this.romanNumeral = intToRoman(number);
    }

    String getRomanNumeral(){
        return romanNumeral;
    }

    String intToRoman(int number){
        int l = treemap.floorKey(number);   
        if (number == l) return treemap.get(number);
        return treemap.get(l).concat(intToRoman(number - l));
    }
}