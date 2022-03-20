package seedu.address.logic.parser;

import static seedu.address.logic.parser.CliSyntax.SEND_PREFIX_CLIENT;
import static seedu.address.logic.parser.CliSyntax.SEND_PREFIX_POST;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.SendCommand;
import seedu.address.logic.parser.exceptions.ParseException;


public class SendCommandParser implements Parser<SendCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SendCommand
     * and returns a SendCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public SendCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, SEND_PREFIX_CLIENT, SEND_PREFIX_POST);

        List<Index> clientIdx = ParserUtil.parseIndexList(argMultimap.getValue(SEND_PREFIX_CLIENT).get());
        List<Index> postIdx = ParserUtil.parseIndexList(argMultimap.getValue(SEND_PREFIX_POST).get());

        return new SendCommand(clientIdx, postIdx);
    }

}
