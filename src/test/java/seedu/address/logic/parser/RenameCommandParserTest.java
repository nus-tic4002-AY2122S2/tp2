package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.ParserUtilTest.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.RenameCommand;

class RenameCommandParserTest {
    private RenameCommandParser parser = new RenameCommandParser();

    @Test
    void parse() {
        // null -> returns parseException
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, RenameCommand.MESSAGE_USAGE));
    }
}
