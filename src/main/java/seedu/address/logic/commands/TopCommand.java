package seedu.address.logic.commands;

import java.util.List;

import seedu.address.model.Model;
import seedu.address.model.person.Person;


/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class TopCommand extends Command {

    public static final String COMMAND_WORD = "top";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds Top persons whose "
            + "has the top score in the subject"
            + "Example: " + COMMAND_WORD + " english";

    public static final String MESSAGE_TOP_PERSON = "Top %1$s Scorer: %2$s %3$d";

    public static final String MESSAGE_SUBJECT_ERROR = "Please pass in the correct Subject english, science,"
            + " mathematics, mothertongue or total";

    public final String subject;

    public TopCommand(String subject) {
        this.subject = subject;
    }


    @Override
    public CommandResult execute(Model model) {
        int index = 0;
        int topScore = 0;
        int currentScore = 0;
        List<Person> lastShownList = model.getFilteredPersonList();
        for (int i = 0; i < lastShownList.size(); i++) {
            switch (subject) {

            case "english":
                if (i == 0) {
                    topScore = lastShownList.get(i).getEnglish().score;
                }
                currentScore = lastShownList.get(i).getEnglish().score;
                if (topScore < currentScore) {
                    topScore = currentScore;
                    index = i;
                }
                break;

            case "science":
                if (i == 0) {
                    topScore = lastShownList.get(i).getScience().score;
                }
                currentScore = lastShownList.get(i).getScience().score;
                if (topScore < currentScore) {
                    topScore = currentScore;
                    index = i;
                }
                break;

            case "mathematics":
                if (i == 0) {
                    topScore = lastShownList.get(i).getMathematics().score;
                }
                currentScore = lastShownList.get(i).getMathematics().score;
                if (topScore < currentScore) {
                    topScore = currentScore;
                    index = i;
                }
                break;

            case "mothertongue":
                if (i == 0) {
                    topScore = lastShownList.get(i).getMotherTongue().score;
                }
                currentScore = lastShownList.get(i).getMotherTongue().score;
                if (topScore < currentScore) {
                    topScore = currentScore;
                    index = i;
                }
                break;

            case "total":
                if (i == 0) {
                    topScore = lastShownList.get(i).getEnglish().score + lastShownList.get(i).getMathematics().score 
                    + lastShownList.get(i).getMotherTongue().score + lastShownList.get(i).getScience().score;
                }
                currentScore = lastShownList.get(i).getEnglish().score + lastShownList.get(i).getMathematics().score
                + lastShownList.get(i).getMotherTongue().score + lastShownList.get(i).getScience().score;
                if(topScore < currentScore) {
                    topScore = currentScore;
                    index = i;
                }
                break;

            default:
                return new CommandResult(
                        String.format(MESSAGE_SUBJECT_ERROR));
            }

        }
        Person personToEdit = lastShownList.get(index);
        return new CommandResult(
                String.format(MESSAGE_TOP_PERSON, subject, personToEdit.getName(), topScore));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TopCommand // instanceof handles nulls
                && subject.equals(((TopCommand) other).subject)); // state check
    }
}
