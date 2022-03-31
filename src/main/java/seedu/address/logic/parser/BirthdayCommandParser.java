package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.BirthdayCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.NameContainsMonthPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class BirthdayCommandParser implements Parser<BirthdayCommand> {

    private static final Logger logger = LogsCenter.getLogger(BirthdayCommandParser.class);

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public BirthdayCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, BirthdayCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");
        for (String temp: nameKeywords) {
            try {
                int month = Integer.parseInt(temp);
                if (month < 1 || month > 12) {
                    throw new ParseException(BirthdayCommand.MESSAGE_INVALID_MONTH);
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        logger.info("======================[ Bday Parse with arguments ] Month " + trimmedArgs + " ===========");

        return new BirthdayCommand(new NameContainsMonthPredicate(Arrays.asList(nameKeywords)));
    }

}
