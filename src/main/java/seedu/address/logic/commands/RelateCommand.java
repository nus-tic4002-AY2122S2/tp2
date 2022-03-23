package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RELATE;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Person;


public class RelateCommand extends Command {

    public static final String COMMAND_WORD = "relate";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": 1 to n mutual relationship "
            + "by the index number used in the displayed person list.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_RELATE + " "
            + "[INDEX1] "
            + "[INDEX2] "
            + "[INDEX3]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_RELATE + " 2 3 4\n"
            + "OR if " + COMMAND_WORD + " follow only by one INDEX\n"
            + "Example: " + COMMAND_WORD + " 1 \n"
            + "All related person cards will be printed";

    public static final String MESSAGE_RELATE_SUCCESS = "They are related to %1$s";
    private final Index to;
    private List<Index> from;

    /**
     * @param to
     */
    public RelateCommand(Index to) {
        requireNonNull(to);
        this.to = to;
    }

    /**
     * @param to
     * @param from
     */
    public RelateCommand(Index to, List<Index> from) {
        requireNonNull(to);
        requireNonNull(from);
        this.to = to;
        this.from = from;
    }

    @Override
    public CommandResult execute(Model model, ReadOnlyAddressBook
            originalAddressBook, String exCommand) throws CommandException,
            ParseException {
        requireNonNull(model);

        List<Person> lastShownList = model.getFilteredPersonList();

        if (to.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personTo = lastShownList.get(to.getZeroBased());

        if (!from.isEmpty()) {

        }
            // return new CommandResult("Hello from remark");

        return new CommandResult("Hello from remark");
    }

    private static void relate () {

    }

}
