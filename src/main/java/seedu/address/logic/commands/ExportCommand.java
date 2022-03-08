package seedu.address.logic.commands;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.address.MainApp;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Person;

import static java.util.Objects.requireNonNull;

public class ExportCommand extends Command {

    public static final String COMMAND_WORD = "export";
    public static final String MESSAGE_SUCCESS = "Data exported successfully.";

    private static ObservableList<Person> PERSON_LIST;
    private static final Logger logger = LogsCenter.getLogger(MainApp.class);

    public ExportCommand() { }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        this.PERSON_LIST = model.getAddressBook().getPersonList();

        Person p = PERSON_LIST.getPersonList().get(0);
        logger.info("--------------First person's name: "
                      + p.getName() + "-------------");

        return new CommandResult(MESSAGE_SUCCESS);
    }
}
