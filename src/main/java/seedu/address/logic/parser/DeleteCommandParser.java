package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommonRegexPattern.BASIC_TYPE_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ListType;

import java.util.regex.Matcher;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {

            final Matcher matcherType = BASIC_TYPE_FORMAT.matcher(args.trim());
            ListType listType;
            String args1;
            if (matcherType.matches()) {
                listType = (!(matcherType.group("isClient") == null) &&
                        !(matcherType.group("isClient").isEmpty())) ? ListType.CLIENT :
                        (!(matcherType.group("isPost") == null) &&
                        !(matcherType.group("isPost").isEmpty())) ? ListType.POST : null;
                args1 = matcherType.group("args");
                try {
                    Index index = ParserUtil.parseIndex(args1);
                    return new DeleteCommand(listType, index);
                } catch (ParseException pe) {
                    throw new ParseException(
                            String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE), pe);
                }
            } else {
                throw new ParseException("You need declare which list you want to delete from");
            }

    }

}


