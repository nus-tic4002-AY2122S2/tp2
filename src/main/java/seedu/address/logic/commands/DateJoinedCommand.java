package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;


/**
 * Changes the date joined of an existing person in the address book.
 */
public class DateJoinedCommand extends Command {
    public static final String COMMAND_WORD = "date joined";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the date joined of the person identified "
            + "by the index number used in the last person listing. "
            + "Existing date joined will be overwritten by the input.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_REMARK + "[REMARK]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_REMARK + "Likes to swim.";

    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Date Joined: %2$s";

    private final Index index;
    private final String dateJoined;

    /**
     * @param index of the person in the filtered person list to edit the date joined
     * @param dateJoined of the person to be updated to
     */
    public DateJoinedCommand(Index index, String dateJoined) {
        requireAllNonNull(index, dateJoined);

        this.index = index;
        this.dateJoined = dateJoined;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        model.commitAddressBook(model.getAddressBook());
        throw new CommandException(String.format(MESSAGE_ARGUMENTS, index.getOneBased(), dateJoined));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DateJoinedCommand)) {
            return false;
        }

        // state check
        DateJoinedCommand e = (DateJoinedCommand) other;
        return index.equals(e.index) && dateJoined.equals(e.dateJoined);
    }
}
