package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_HELP_MESSAGE = "Adding a person: add n/NAME p/PHONE_NUMBER "
            + "e/EMAIL a/ADDRESS c/CLASSROOM en/SCORE mt/SCORE m/SCORE s/SCORE\n"
            + "Listing all persons : list\n"
            + "Editing a person : edit INDEX [n/NAME] [p/PHONE_NUMBER] "
            + "[a/ADDRESS] [e/EMAIL] [c/CLASSROOM] [en/ENGLISH] [mt/MOTHER TONGUE] "
            + "[m/MATH] [s/SCIENCE] [rt/RECEIVE_TYPE] [t/TAGS]\n"
            + "Locating persons by name: find NAME\n"
            + "Deleting a person : delete INDEX\n"
            + "Find top scorer for the subject: top SUBJECT\n"
            + "Find last scorer for the subject: last SUBJECT\n"
            + "Clearing all entries : clear\n"
            + "Exiting the program : exit\n";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(SHOWING_HELP_MESSAGE, true, false);
    }
}
