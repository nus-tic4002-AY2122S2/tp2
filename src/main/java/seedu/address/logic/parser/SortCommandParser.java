package seedu.address.logic.parser;

import seedu.address.logic.commands.SortCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortCommandParser implements Parser<SortCommand> {

    private static final Pattern SORT_KEYWORD_ORDER_ARGS = Pattern.compile("(?<keyword>postdate)\\s+(?<order>asc|desc)");

    /**
     * Parses the given {@code String} of arguments in the context of the SortCommand
     * and returns a SortCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public SortCommand parse(String args) throws ParseException {
        Matcher matcher = SORT_KEYWORD_ORDER_ARGS.matcher(args.trim());

        if(!matcher.matches()){
            throw new ParseException("This is not a correct sort command");
        }

        String keyword = matcher.group("keyword");
        String order = matcher.group("order");

        return new SortCommand(keyword, order);
    }
}
