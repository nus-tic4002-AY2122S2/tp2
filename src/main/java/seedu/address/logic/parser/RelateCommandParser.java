package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RELATE;

import java.util.List;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.RelateCommand;
import seedu.address.logic.parser.exceptions.ParseException;



public class RelateCommandParser implements Parser<RelateCommand> {

    private static final Logger logger = LogsCenter.getLogger(RelateCommandParser.class);

    @Override
    public RelateCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argumentMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_RELATE);

        logger.info("=============================[ Relate Parse with arguments ]===========================");

        Index to = getIndex(argumentMultimap);
        if (!argumentMultimap.getValue(PREFIX_RELATE).isPresent()) {
            return new RelateCommand(to);
        } else {
            List<Index> from = getIndices(argumentMultimap);
            return new RelateCommand(to, from);
        }
    }


    public static Index getIndex(ArgumentMultimap argMultimap) throws ParseException {
        try {
            return ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, RelateCommand.MESSAGE_USAGE), pe);
        }
    }

    public static List<Index> getIndices(ArgumentMultimap argMultimap) throws ParseException {
        try {
            return ParserUtil.parseIndexList(argMultimap.getValue(PREFIX_RELATE));
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, RelateCommand.MESSAGE_USAGE), pe);
        }
    }
}
