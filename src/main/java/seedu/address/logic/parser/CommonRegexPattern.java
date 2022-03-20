package seedu.address.logic.parser;

import java.util.regex.Pattern;

public class CommonRegexPattern {

    public static final Pattern BASIC_TYPE_FORMAT =
            Pattern.compile("((?<isClient>client|c)|(?<isPost>post|p))(?<args>.*)");

    public static final Pattern INDEX_LIST_ARGS_FORMAT = Pattern.compile("(?<targetIndex>\\d+(?:\\s+\\d+)*)");


}
