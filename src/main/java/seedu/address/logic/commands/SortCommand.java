package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.Comparator;

import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;

public abstract class SortCommand extends Command implements Comparable<Person> {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_SUCCESS = "Sorted all persons";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sort all persons by names \n";

    private static Comparator<Person> ascComparator = new Comparator<Person>() {

        @Override
        public int compare(Person o1, Person o2) {
            Name p1 = o1.getName();
            Name p2 = o2.getName();

            return p1.fullName.compareTo(p2.fullName);
        }
    };

    @Override
    public CommandResult execute(Model model, ReadOnlyAddressBook originalAddressBook, String exCommand) {
        requireNonNull(model);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }

}
