package seedu.address.commons.util;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Helper functions for handling strings.
 */
public class StringUtil {

    private static final Logger logger = Logger.getLogger(StringUtil.class.getName());

    /**
     * Returns true if the {@code sentence} contains the {@code word}.
     *   Ignores case, but a full word match is required.
     *   <br>examples:<pre>
     *       containsWordIgnoreCase("ABc def", "abc") == true
     *       containsWordIgnoreCase("ABc def", "DEF") == true
     *       containsWordIgnoreCase("ABc def", "AB") == false //not a full word match
     *       </pre>
     * @param sentence cannot be null
     * @param word cannot be null, cannot be empty, must be a single word
     */
    public static boolean containsWordIgnoreCase(String sentence, String word) {
        requireNonNull(sentence);
        requireNonNull(word);

        String preppedWord = word.trim();
        checkArgument(!preppedWord.isEmpty(), "Word parameter cannot be empty");
        checkArgument(preppedWord.split("\\s+").length == 1, "Word parameter should be a single word");

        String preppedSentence = sentence;
        String[] wordsInPreppedSentence = preppedSentence.split("\\s+");

        return Arrays.stream(wordsInPreppedSentence)
                .anyMatch(preppedWord::equalsIgnoreCase);
    }

    /**
     * Returns true if the {@code sentence} contains the {@code tag}.
     *   Ignores case, but a full word match is required.
     *   <br>examples:<pre>
     *       containsTagIgnoreCase("ABc def", "abc") == true
     *       containsTagIgnoreCase("ABc def", "DEF") == true
     *       containsTagIgnoreCase("ABc def", "AB") == false //not a full word match
     *       </pre>
     * @param sentence cannot be null
     * @param tag cannot be null, cannot be empty, must be a single word
     */
    public static boolean containsTagIgnoreCase(String sentence, String tag) {
        requireNonNull(sentence);
        requireNonNull(tag);

        String preppedWord = tag.trim();
        checkArgument(!preppedWord.isEmpty(), "Tag parameter cannot be empty");
        checkArgument(preppedWord.split("\\s+").length == 1, "Tag parameter should be a single word");

        String preppedSentence = sentence.replace("[", "").replace("]", "").replace(" ", "");
        String[] wordsInPreppedSentence = preppedSentence.split(",");

        return Arrays.stream(wordsInPreppedSentence)
                .anyMatch(preppedWord::equalsIgnoreCase);
    }

    /**
     * Returns true if the {@code sentence} contains the {@code tag}.
     * @param sentence cannot be null
     * @param month cannot be null, cannot be empty
     */
    public static boolean containsMonth(String sentence, String month) {
        requireNonNull(sentence);
        requireNonNull(month);

        try {
            int number = Integer.parseInt(month);
            assert (0 < number && number < 13) : "month parameter should be within 1 to 12";
        } catch (AssertionError ex) {
            logger.log(Level.WARNING, "month parameter is out of bound", ex);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        if (month.length() == 1) {
            month = "0" + month;
        }

        String preppedWord = month;
        checkArgument(!preppedWord.isEmpty(), "Tag parameter cannot be empty");
        checkArgument(preppedWord.split("\\s+").length == 1, "Tag parameter should be a single word");

        String[] extractMonth = sentence.split("-");
        String preppedSentence = extractMonth[1].replace("[", "").replace("]", "").replace(" ", "");
        String[] wordsInPreppedSentence = preppedSentence.split(",");

        return Arrays.stream(wordsInPreppedSentence)
                .anyMatch(preppedWord::equalsIgnoreCase);
    }

    /**
     * Returns a detailed message of the t, including the stack trace.
     */
    public static String getDetails(Throwable t) {
        requireNonNull(t);
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        return t.getMessage() + "\n" + sw.toString();
    }

    /**
     * Returns true if {@code s} represents a non-zero unsigned integer
     * e.g. 1, 2, 3, ..., {@code Integer.MAX_VALUE} <br>
     * Will return false for any other non-null string input
     * e.g. empty string, "-1", "0", "+1", and " 2 " (untrimmed), "3 0" (contains whitespace), "1 a" (contains letters)
     * @throws NullPointerException if {@code s} is null.
     */
    public static boolean isNonZeroUnsignedInteger(String s) {
        requireNonNull(s);

        try {
            int value = Integer.parseInt(s);
            return value > 0 && !s.startsWith("+"); // "+1" is successfully parsed by Integer#parseInt(String)
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
