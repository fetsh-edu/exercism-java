import java.util.Arrays;
import java.util.stream.IntStream;

class Proverb {

    String proverb;

    Proverb(String[] words) {
        this.proverb = proverb(words);
    }

    String recite() {
        return proverb;
    }

    String proverb(String[] words){
        if (words.length == 0) return "";
        return IntStream.range(0, words.length - 1)
                .mapToObj(i -> String.format("For want of a %s the %s was lost.\n", words[i], words[i+1]))
                .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append)
                .append(String.format("And all for the want of a %s.", words[0]))
                .toString();
    }
}
