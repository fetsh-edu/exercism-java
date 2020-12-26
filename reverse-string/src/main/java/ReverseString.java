import java.util.stream.IntStream;

class ReverseString {

    String reverse(String inputString) {
        return IntStream.iterate(inputString.length() - 1, i -> i - 1)
                .limit(inputString.length())
                .mapToObj(inputString::charAt)
                .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append)
                .toString();
    }
  
}
