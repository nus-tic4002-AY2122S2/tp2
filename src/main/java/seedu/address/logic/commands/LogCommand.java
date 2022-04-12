package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LOG;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Log;
import seedu.address.model.person.Person;

public class LogCommand extends Command {
    public static final String COMMAND_WORD = "log";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the log of the person identified "
            + "by the index number used in the last person listing. "
            + "Existing log will be overwritten by the input.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_LOG + "[LOG]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_LOG + "Informed of start of next Sprint02 next Tues.";
    public static final String MESSAGE_ADD_LOG_SUCCESS = "Added log to Person: %1$s";
    public static final String MESSAGE_DELETE_LOG_SUCCESS = "Removed log from Person: %1$s";
    private final Index index;
    private final Log log;

    /**
     * @param index of the person in the filtered person list to edit the remark
     * @param log of the person to be updated to
     */
    public LogCommand(Index index, Log log) {
        requireAllNonNull(index, log);

        this.index = index;
        this.log = log;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());
        Person editedPerson = new Person(
                personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(),
                personToEdit.getAddress(), personToEdit.getDateJoined(), personToEdit.getRemark(), log,
                personToEdit.getTags());

        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        model.commitAddressBook(model.getAddressBook());
        return new CommandResult(generateSuccessMessage(editedPerson));
    }

    /**
     * Generates a command execution success message based on whether
     * the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Person personToEdit) {
        String message = !log.value.isEmpty() ? MESSAGE_ADD_LOG_SUCCESS : MESSAGE_DELETE_LOG_SUCCESS;
        return String.format(message, personToEdit);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof LogCommand)) {
            return false;
        }

        // state check
        LogCommand e = (LogCommand) other;
        return index.equals(e.index)
                && log.equals(e.log);
    }
}
