package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Changes the remark of an existing person in the address book.
 */
public class DescriptionCommand extends Command {
    //...
    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Description: %2$s";

    private final Index index;
    private final String description;

    /**
     * @param index of the person in the filtered person list to edit the description
     * @param description of the person to be updated to
     */
    public DescriptionCommand(Index index, String description) {
        requireAllNonNull(index, description);

        this.index = index;
        this.description = description;
    }
    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException(
                String.format(MESSAGE_ARGUMENTS, index.getOneBased(), description));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DescriptionCommand)) {
            return false;
        }

        // state check
        DescriptionCommand e = (DescriptionCommand) other;
        return index.equals(e.index)
                && description.equals(e.description);
    }

    public v parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args,
                PREFIX_DESCRIPTION);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    DescriptionCommand.MESSAGE_USAGE), ive);
        }

        String description = argMultimap.getValue(PREFIX_DESCRIPTION).orElse("");

        return new DescriptionCommand(index, description);
    }
}