package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RELATE;

import java.util.List;
import java.util.Optional;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Person;
import seedu.address.model.person.RelateToPersonPredicate;


public class RelateCommand extends Command {

    public static final String COMMAND_WORD = "relate";
    public static final String MESSAGE_RELATE_SUCCESS = " has Relation with: ";

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
    //
    private final Index to;
    private Optional<List<Index>> from = Optional.empty();

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
        this.from = Optional.of(from);
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

        if (from.isPresent()) {
            List<Index> indices = from.get();
            for (Index i : indices) {
                Person personFrom = lastShownList.get(i.getZeroBased());
                if (!personFrom.equals(personTo)) {
                    // personTo.addRelation(personFrom.getName().fullName);
                    // personFrom.addRelation(personTo.getName().fullName);
                    personTo.relatedWith(personFrom);
                    personFrom.relatedWith(personTo);
                }
            }
        }
        RelateToPersonPredicate predicate = new RelateToPersonPredicate(personTo);
        model.updateFilteredPersonList(predicate);

        return new CommandResult(personTo.getName().fullName
                + MESSAGE_RELATE_SUCCESS
                + personTo.getRelation().toString());
    }

    private static void relate () {

    }

}
