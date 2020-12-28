import java.util.regex.Pattern;

class PhoneNumber{

    private final String areaCode;
    private final String exchangeCode;
    private final String subscriberNumber;

    PhoneNumber(String phoneNumber) {
        var number = strip(phoneNumber);
        if (number.length() < 10) throw new IllegalArgumentException("incorrect number of digits");
        if (number.length() > 11) throw new IllegalArgumentException("more than 11 digits");
        if (number.matches(".*[a-zA-Z]+.*")) throw new IllegalArgumentException("letters not permitted");
        if (!number.matches("\\d+")) throw new IllegalArgumentException("punctuations not permitted");
        var m = Pattern.compile("(\\d?)(\\d{3})(\\d{3})(\\d{4})").matcher(number);
        if (m.matches()) {
            this.areaCode = m.group(2);
            if (areaCode.startsWith("0")) throw new IllegalArgumentException("area code cannot start with zero");
            if (areaCode.startsWith("1")) throw new IllegalArgumentException("area code cannot start with one");

            this.exchangeCode = m.group(3);
            if (exchangeCode.startsWith("0")) throw new IllegalArgumentException("exchange code cannot start with zero");
            if (exchangeCode.startsWith("1")) throw new IllegalArgumentException("exchange code cannot start with one");

            this.subscriberNumber = m.group(4);
            if(!m.group(1).isEmpty() && !m.group(1).equals("1")) throw new IllegalArgumentException("11 digits must start with 1");

        } else {
            throw new IllegalArgumentException();
        }
    }

    String strip(String number) {
        return number.replaceAll("([-+.()]|\\s)+", "");
    }
    String getNumber() {
        return String.format("%s%s%s", areaCode, exchangeCode, subscriberNumber);
    }
}