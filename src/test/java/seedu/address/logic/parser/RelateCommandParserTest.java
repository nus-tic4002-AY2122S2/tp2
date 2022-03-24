package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RELATE;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class RelateCommandParserTest {
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");
    private static final String CORRECT = "relate 1 <- 2 3 4";

    private RelateCommandParser parser = new RelateCommandParser();
    private ArgumentMultimap argumentMultimap;


    @Test
    public void parse_index_success() throws ParseException {
        Index to = Index.fromOneBased(1);
        Index from1 = Index.fromOneBased(2);
        Index from2 = Index.fromOneBased(3);
        Index from3 = Index.fromOneBased(4);

        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(CORRECT.strip());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }
        final String arguments = matcher.group("arguments");
        argumentMultimap = ArgumentTokenizer.tokenize(arguments, PREFIX_RELATE);
        //
        Index to_test = parser.getIndex(argumentMultimap);
        List<Index> indices = parser.getIndices(argumentMultimap);

        assertEquals(to, to_test);
        assertEquals(from1, indices.get(0));
        assertEquals(from2, indices.get(1));
        assertEquals(from3, indices.get(2));
    }
}
