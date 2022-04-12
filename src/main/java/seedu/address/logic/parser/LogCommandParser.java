package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LOG;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.LogCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Log;

/**
 * Parses input arguments and creates a new {@code LogCommand} object
 */
public class LogCommandParser implements Parser<LogCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code LogCommand}
     * and returns a {@code LogCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public LogCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_LOG);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, LogCommand.MESSAGE_USAGE), ive);
        }

        String log = argMultimap.getValue(PREFIX_LOG).orElse("");

        return new LogCommand(index, new Log(log));
    }
}
