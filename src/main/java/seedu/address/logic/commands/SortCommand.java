package seedu.address.logic.commands;

import java.util.Comparator;
import java.util.logging.Logger;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;

import static java.util.Objects.requireNonNull;

import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

public abstract class SortCommand extends Command implements Comparable<Person>{

    private static final Logger logger = LogsCenter.getLogger(SortCommand.class);

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_SUCCESS = "Sorted all persons";


    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sort all persons by names \n"
//            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + "";

    @Override
    public CommandResult execute(Model model, ReadOnlyAddressBook originalAddressBook, String exCommand) {
        requireNonNull(model);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
//        Collections.sort(originalAddressBook.getPersonList(), ascComparator);
        return new CommandResult(MESSAGE_SUCCESS);
    }

    public static Comparator<Person> ascComparator = new Comparator<Person>() {

        @Override
        public int compare(Person o1, Person o2) {
            Name p1 = o1.getName();
            Name p2 = o2.getName();

            return p1.fullName.compareTo(p2.fullName);
        }
    };

}
