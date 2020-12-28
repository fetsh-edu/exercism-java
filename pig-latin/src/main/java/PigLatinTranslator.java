import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class PigLatinTranslator {
    String translate(String word){
        return Arrays.stream(word.split("\s+")).map(this::translateWord).collect(Collectors.joining(" "));
    }

    String translateWord(String word){
        return mutateWord(word).concat("ay");
    }

    String mutateWord(String word){
        if(word.matches("^([aeiou]|xr|yt).*")) return word;

        Matcher m  = Pattern.compile("^([^aeiou]+qu).*").matcher(word);
        if (m.matches()) return word.replaceFirst("[^aeiou]+qu", "").concat(m.group(1));

        m.usePattern(Pattern.compile("^([^aeiou]+)y+.*"));
        if (m.matches()) return word.replaceFirst("[^aeiouy]+", "").concat(m.group(1));

        m.usePattern(Pattern.compile("^(qu|[^aeiou]+).*"));
        if (m.matches()) return word.replaceFirst("(qu|[^aeiou]+)", "").concat(m.group(1));

        return word;
    }
}