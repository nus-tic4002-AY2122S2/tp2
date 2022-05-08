package seedu.address.logic.parser;

import java.util.regex.Pattern;

public class CommonRegexPattern {

    public static final Pattern BASIC_TYPE_FORMAT =
            Pattern.compile("((?<isClient>client|c)|(?<isPost>post|p))(?<args>(.|\\s)*)");

    public static final Pattern INDEX_LIST_ARGS_FORMAT = Pattern.compile("(?<targetIndex>\\d+(?:\\s+\\d+)*)");

    public static final Pattern BASIC_DATE_TIME_FORMAT =
            Pattern.compile("(?<year>\\d{4})(?<month>\\d{2})(?<day>\\d{2})"
                    + " " + "(?<hour>\\d{2})(?<minute>\\d{2})");

}
