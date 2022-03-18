package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Person;

/**
 * Copy a contact.
 */
public class CopyCommand extends Command {

    public static final String COMMAND_WORD = "copy";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Copy a contact and its details.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "Example: " + COMMAND_WORD + " 1 ";

    public static final String MESSAGE_COPY_SUCCESS = "Successfully copied contact: %1$s";

    private final Index index;

    /**
     * @param index of the person in the filtered person list to edit
     */
    public CopyCommand(Index index) {
        requireNonNull(index);

        this.index = index;
    }

    @Override
    public CommandResult execute(Model model, ReadOnlyAddressBook originalAddressBook,
                                    String exCommand) throws CommandException, ParseException {
        requireNonNull(model);

        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToCopy = lastShownList.get(index.getZeroBased());

        StringSelection stringSelection = new StringSelection(personToCopy.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        return new CommandResult(String.format(MESSAGE_COPY_SUCCESS, personToCopy));
    }
}
