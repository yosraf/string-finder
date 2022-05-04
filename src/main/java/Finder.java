import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public class Finder {

    private String[] strings;

    public Finder(String[] strings) {
        this.strings = preproccess(strings);
    }

    /**
     * Validates input
     * removes redundant strings
     * rempves null strings
     * removes empty strings
     * removes blank strings
     *
     * @param strings string array to preproccess
     * @return preprocessed string array
     **/

    private String[] preproccess(String[] strings) {
        if (strings == null) {
            throw new IllegalArgumentException("string array could not be null");
        }
        if (strings.length == 0) {
            throw new IllegalArgumentException("string array could not be empty");
        }
        return Arrays.stream(strings).filter(Objects::nonNull).filter(Predicate.not(String::isBlank)).filter(Predicate.not(String::isEmpty))
                .distinct().toArray(String[]::new);
    }

    /**
     * Finds a given string within an array regardless  caracters order
     *
     * @param string: string to be found
     * @return String[] array of string matchers
     **/
    public String[] find(String string) {
        validate(string);
        return Arrays.stream(this.strings).filter(s -> s.length() == string.length() && sort(s).equalsIgnoreCase(sort(string))
        ).toArray(String[]::new);
    }

    /**
     * Sorts a given string by its ASCII codes
     *
     * @param string to be sorted
     * @return sorted string
     **/
    private String sort(String string) {
        return string.toLowerCase().chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    /**
     * validates string input
     *
     * @throws IllegalArgumentException when input is invalid
     **/
    private void validate(String string) {

        if (string == null) {
            throw new IllegalArgumentException("string input could not be null");
        }
        if (string.isEmpty()) {
            throw new IllegalArgumentException("string input could not be empty");
        }

    }

}
