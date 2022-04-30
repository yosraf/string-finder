import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FinderTest {

    private Finder finder;

    private static final String NULL_STRING_COULD_NOT_BE_NULL_MSG="string input could not be null";
    private static final String NULL_ARRAY_STRING_COULD_NOT_BE_NULL_MSG="string array could not be null";
    private static final String EMPTY_ARRAY_STRING_COULD_NOT_BE_NULL_MSG="string array could not be empty";
    private static final String EMPTY_STRING_COULD_NOT_BE_NULL_MSG="string input could not be empty";

    @Test
    @DisplayName("givenGoodStringWhenFindThenReturnOneMatch")
    public void givenGoodStringWhenFindThenReturnOneMatch() {
        //***** Given
        // good string
        String s1 = "sad";
        // good array string
        String[] strings = new String[5];
        strings[0] = "asd";
        strings[1] = "asdd";
        strings[2] = "fre";
        strings[3] = "glk";
        strings[4] = "lkm";
        this.finder = new Finder(strings);

        //***** When
        String[] result = finder.find(s1);

        //***** Then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.length);
        Assertions.assertEquals("asd", result[0]);


    }
    @Test
    @DisplayName("givenUpperCaseStringWhenFindThenReturnMatches")
    public void givenUpperCaseStringWhenFindThenReturnMatches() {
        //***** Given
        // good string
        String s1 = "CBD";
        // good array string
        String[] strings = new String[5];
        strings[0] = "cbd";
        strings[1] = "dbc";
        strings[2] = "dbcer";
        strings[3] = "bCD";
        strings[4] = "BdC";
        this.finder = new Finder(strings);

        //***** When
        String[] result = finder.find(s1);

        //***** Then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(4, result.length);


    }
    @Test
    @DisplayName("givenGoodStringWhenFindThenReturnEmptyMatch")
    public void givenGoodStringWhenFindThenReturnEmpty() {
        //***** Given
        // good string
        String s1 = "none";
        // good array string
        String[] strings = new String[5];
        strings[0] = "asd";
        strings[1] = "asdd";
        strings[2] = "fre";
        strings[3] = "glk";
        strings[4] = "lkm";
        this.finder = new Finder(strings);

        //***** When
        String[] result = finder.find(s1);

        //***** Then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.length);


    }
    @Test
    @DisplayName("givenGoodStringWhenFindThenReturnMatches")
    public void givenGoodStringWhenFindThenReturnMatches() {
        //***** Given
        // good string
        String s1 = "sad";
        // good array string
        String[] strings = new String[15];
        strings[0] = "asd";
        strings[1] = "sad";
        strings[2] = "das";
        strings[3] = "glk";
        strings[4] = "lkm";
        strings[5] = "asd";
        strings[6] = "asdd";
        strings[7] = "fre";
        strings[8] = "glk";
        strings[9] = "lkm";
        strings[10] = "asd";
        strings[11] = "asdd";
        strings[12] = "fre";
        strings[13] = "glk";
        strings[14] = "lkm";
        this.finder = new Finder(strings);

        //***** When
        String[] result = finder.find(s1);

        //***** Then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(5, result.length);

    }
    @Test
    @DisplayName("givenNullStringWhenFindThenThrowIllegalArgumentException")
    public void givenNullStringWhenFindThenThrowIllegalArgumentException() {
        //***** Given
        // null string
        String s1 = null;
        // good array string
        String[] strings = new String[1];
        strings[0] = "asd";

        this.finder = new Finder(strings);


        IllegalArgumentException exception =Assertions.assertThrows(IllegalArgumentException.class,()->{
            //***** When
            finder.find(s1);
        });

        //**** Then
        Assertions.assertEquals(NULL_STRING_COULD_NOT_BE_NULL_MSG,exception.getMessage());

    }
    @Test
    @DisplayName("givenEmptyStringWhenFindThenThrowIllegalArgumentException")
    public void givenEmptyStringWhenFindThenThrowIllegalArgumentException() {
        //***** Given
        // null string
        String s1 = "";
        // good array string
        String[] strings = new String[1];
        strings[0] = "asd";

        this.finder = new Finder(strings);


        IllegalArgumentException exception =Assertions.assertThrows(IllegalArgumentException.class,()->{
            //***** When
            finder.find(s1);
        });

        //**** Then
        Assertions.assertEquals(EMPTY_STRING_COULD_NOT_BE_NULL_MSG,exception.getMessage());

    }
    @Test
    @DisplayName("givenEmptyStringArrayWhenFindThenThrowIllegalArgumentException")
    public void givenEmptyStringArrayWhenFindThenThrowIllegalArgumentException() {
        //***** Given
        // valid string
        String s1 = "asb";
        // empty array string
        String[] strings = new String[0];

        this.finder = new Finder(strings);


        IllegalArgumentException exception =Assertions.assertThrows(IllegalArgumentException.class,()->{
            //***** When
            finder.find(s1);
        });

        //**** Then
        Assertions.assertEquals(EMPTY_ARRAY_STRING_COULD_NOT_BE_NULL_MSG,exception.getMessage());

    }
    @Test
    @DisplayName("givenNulltringArrayWhenFindThenThrowIllegalArgumentException")
    public void givenNullStringArrayWhenFindThenThrowIllegalArgumentException() {
        //***** Given
        // valid string
        String s1 = "asb";
        // null array string
        String[] strings = null;

        this.finder = new Finder(strings);


        IllegalArgumentException exception =Assertions.assertThrows(IllegalArgumentException.class,()->{
            //***** When
            finder.find(s1);
        });

        //**** Then
        Assertions.assertEquals(NULL_ARRAY_STRING_COULD_NOT_BE_NULL_MSG,exception.getMessage());

    }
}
