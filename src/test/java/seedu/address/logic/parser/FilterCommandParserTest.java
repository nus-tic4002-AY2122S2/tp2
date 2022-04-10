package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.ParserUtilTest.assertParseFailure;
import static seedu.address.logic.parser.ParserUtilTest.assertParseSuccess;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FilterCommand;
import seedu.address.model.person.NameContainsTagPredicate;

class FilterCommandParserTest {
    private FilterCommandParser parser = new FilterCommandParser();

    @Test
    void parse() {
        // null -> returns parseException
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_USAGE));

        // test valid args -> returns success
        FilterCommand expectedCommand =
                new FilterCommand(new NameContainsTagPredicate(Arrays.asList("g501", "student")));
        assertParseSuccess(parser, "g501 student", expectedCommand);

        // test whitespaces -> returns success
        assertParseSuccess(parser, " \t g501 \t \t student  \t", expectedCommand);
    }
}
