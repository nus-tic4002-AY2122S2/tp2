package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.LogicManager;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.EditCommandParser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
/**
 * Undo the most recent create or delete command.
 */
public class UndoCommand extends Command {

    public static final String COMMAND_WORD = "undo";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Undo the most recent create or delete command.\n"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_EXCOMMAND_IS_UNDO = "Cannot undo an 'undo' command.";
    public static final String MESSAGE_INVALID = "OOPS!!! I'm sorry, but I don't know what that means.";

    public static final String MESSAGE_UNDO_SUCCESS = "Successfully undo!";

    @Override
    public CommandResult execute(Model model, Person modifiedPerson, List<Person> originalAddressBook,
                                    String exCommand) throws CommandException, ParseException {
        requireNonNull(model);

        if (exCommand.contains("undo")) {
            throw new CommandException(MESSAGE_EXCOMMAND_IS_UNDO);
        } else if (exCommand.contains("list") || exCommand.toLowerCase().contains("find")
                    || exCommand.toLowerCase().contains("help")) {
            return LogicManager.getResponse(exCommand);
        } else if (exCommand.contains("delete") || exCommand.contains("clear")) { // TODO
            model.setNewAddressBook(originalAddressBook);
        } else if (exCommand.contains("add")) {
            Index index = ParserUtil.parseIndex(String.valueOf(model.getFilteredPersonList().size()));
            return new DeleteCommand(index).execute(model, modifiedPerson, originalAddressBook, exCommand);
        } else if (exCommand.contains("edit")) { //TODO
            ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(exCommand, PREFIX_NAME, PREFIX_PHONE,
                                                PREFIX_EMAIL, PREFIX_ADDRESS, PREFIX_TAG);

            EditPersonDescriptor editPersonDescriptor = new EditPersonDescriptor();

            editPersonDescriptor.setName(modifiedPerson.getName());
            editPersonDescriptor.setPhone(modifiedPerson.getPhone());
            editPersonDescriptor.setEmail(modifiedPerson.getEmail());
            editPersonDescriptor.setAddress(modifiedPerson.getAddress());
            editPersonDescriptor.setTags(modifiedPerson.getTags());

            return new EditCommand(EditCommandParser.getIndex(argMultimap), editPersonDescriptor)
                                    .execute(model, modifiedPerson, originalAddressBook, exCommand);
        } else {
            throw new CommandException(MESSAGE_INVALID);
        }

        return new CommandResult(MESSAGE_UNDO_SUCCESS);
    }
}
