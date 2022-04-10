package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.ParserUtilTest.assertParseFailure;
import static seedu.address.logic.parser.ParserUtilTest.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.BirthdayCommand;
import seedu.address.model.person.NameContainsMonthPredicate;


class BirthdayCommandParserTest {
    private BirthdayCommandParser parser = new BirthdayCommandParser();

    @Test
    void parse() {
        // null -> returns parseException
        assertParseFailure(parser, "   ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, BirthdayCommand.MESSAGE_USAGE));

        // less than 1 or more than 12 -> returns parseException
        assertParseFailure(parser, "0", BirthdayCommand.MESSAGE_INVALID_MONTH);
        assertParseFailure(parser, "13", BirthdayCommand.MESSAGE_INVALID_MONTH);

        //between 1 and 12 -> returns success
        BirthdayCommand expectedCommand =
                new BirthdayCommand(new NameContainsMonthPredicate(Arrays.asList("1", "12")));
        assertParseSuccess(parser, "1 12", expectedCommand);

    }
}
