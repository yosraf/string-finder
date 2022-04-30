import java.util.Arrays;

public class Finder {

    private String[] strings;

    public Finder(String[] strings) {
        this.strings = strings;
    }

    /**
     * Finds a given string within an array regardless  caracters order
     *
     * @param string: string to be found
     * @return String[] array of string matchers
     **/
    public String[] find(String string) {
        validate(string);
        int length = strings.length;
        String result = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (compareIgnoreOrder(strings[i], string)) {
                result = stringBuilder.append(strings[i]).append(" ").toString();
            }
        }
        if(result.isEmpty()){
            return new String[0];
        }
        return result.split(" ");
    }

    /**
     * comapres the equality of two strings regardless their order
     *
     * @param s1
     * @param s2
     * @return true or false
     **/

    private boolean compareIgnoreOrder(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        // converting s1 and s2 to char arrays
        char[] char1 = s1.toLowerCase().toCharArray();
        char[] char2 = s2.toLowerCase().toCharArray();

        // sorting arrays
        Arrays.sort(char1);
        Arrays.sort(char2);

        // comparing
        return Arrays.equals(char1, char2);

    }

    /**
     * validates string input
     *
     * @throws IllegalArgumentException when input is invalid
     **/
    private void validate(String string) {
        if (this.strings == null) {
            throw new IllegalArgumentException("string array could not be null");
        }
        if (this.strings.length == 0) {
            throw new IllegalArgumentException("string array could not be empty");
        }
        if (string == null) {
            throw new IllegalArgumentException("string input could not be null");
        }
        if (string.isEmpty()) {
            throw new IllegalArgumentException("string input could not be empty");
        }

    }

}
