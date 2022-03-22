package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.person.Person;

import java.util.List;

import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;


/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class TopCommand extends Command {

    public static final String COMMAND_WORD = "top";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds Top persons whose has the top score in the subject"
            + "Example: " + COMMAND_WORD + " english";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Person: %1$s";

    public final String subject;

    public TopCommand(String subject) {
        this.subject = subject;
    }


    @Override
    public CommandResult execute(Model model) {
        System.out.println("command Result");
        System.out.println(subject);
        int index = 0;
        int topScore = 0;
        int currentScore = 0;
        List<Person> lastShownList = model.getFilteredPersonList();
        for(int i=0; i<lastShownList.size();i++){
            if(i==0){
                topScore = lastShownList.get(i).getEnglish().score;
            }
            currentScore = lastShownList.get(i).getEnglish().score;
            if(topScore<currentScore) {
                topScore = currentScore;
                index = i;
            }
        }
        System.out.println(topScore);
        System.out.println(index);
        Person personToEdit = lastShownList.get(index);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(
                String.format(MESSAGE_EDIT_PERSON_SUCCESS, personToEdit.getName()));//model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TopCommand // instanceof handles nulls
                && subject.equals(((TopCommand) other).subject)); // state check
    }
}
