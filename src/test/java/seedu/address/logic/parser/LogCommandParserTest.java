package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LOG;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.LogCommand;
import seedu.address.model.person.Log;

public class LogCommandParserTest {
    private LogCommandParser parser = new LogCommandParser();
    private final String nonEmptyLog = "Some remark.";

    @Test
    public void parse_indexSpecified_success() {
        // have remark
        Index targetIndex = INDEX_FIRST_PERSON;
        String userInput = targetIndex.getOneBased() + " " + PREFIX_LOG + nonEmptyLog;
        LogCommand expectedCommand = new LogCommand(INDEX_FIRST_PERSON, new Log(nonEmptyLog));
        assertParseSuccess(parser, userInput, expectedCommand);

        // no remark
        userInput = targetIndex.getOneBased() + " " + PREFIX_LOG;
        expectedCommand = new LogCommand(INDEX_FIRST_PERSON, new Log(""));
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_missingCompulsoryField_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, LogCommand.MESSAGE_USAGE);

        // no parameters
        assertParseFailure(parser, LogCommand.COMMAND_WORD, expectedMessage);

        // no index
        assertParseFailure(parser, LogCommand.COMMAND_WORD + " " + nonEmptyLog, expectedMessage);
    }
}
