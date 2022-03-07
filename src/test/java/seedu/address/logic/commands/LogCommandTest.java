package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOG_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOG_BOB;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.LogCommand.MESSAGE_ARGUMENTS;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Log;

/**
 * Contains integration tests (interaction with the Model) and unit tests for LogCommand.
 */
public class LogCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute() {
        final Log log = new Log("Some remark");

        assertCommandFailure(new LogCommand(INDEX_FIRST_PERSON, log), model,
                String.format(MESSAGE_ARGUMENTS, INDEX_FIRST_PERSON.getOneBased(), log));
    }

    @Test
    public void equals() {
        final LogCommand standardCommand = new LogCommand(INDEX_FIRST_PERSON,
                new Log(VALID_LOG_AMY));

        // same values -> returns true
        LogCommand commandWithSameValues = new LogCommand(INDEX_FIRST_PERSON,
                new Log(VALID_LOG_AMY));
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new LogCommand(INDEX_SECOND_PERSON,
                new Log(VALID_LOG_AMY))));

        // different remark -> returns false
        assertFalse(standardCommand.equals(new LogCommand(INDEX_FIRST_PERSON,
                new Log(VALID_LOG_BOB))));
    }
}
