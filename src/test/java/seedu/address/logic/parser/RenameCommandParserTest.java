package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.ParserUtilTest.assertParseFailure;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.RenameCommand;
import seedu.address.model.person.NameContainsTagPredicate;

class RenameCommandParserTest {
    private RenameCommandParser parser = new RenameCommandParser();

    void parse() {
        // null -> returns parseException
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, RenameCommand.MESSAGE_USAGE));
    }
}
