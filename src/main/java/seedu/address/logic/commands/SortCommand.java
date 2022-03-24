package seedu.address.logic.commands;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import seedu.address.MainApp;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.Messages;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Name;
import seedu.address.model.person.NameContainsKeywordsPredicate;
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
    public CommandResult execute(Model model, ReadOnlyAddressBook originalAddressBook,
                                 String exCommand) {
        requireNonNull(model);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }

//    @Override
//    public int compare(ReadOnlyAddressBook o1, ReadOnlyAddressBook o2) {
//        ObservableList<Person> p1 = o1.getPersonList();
//        ObservableList<Person> p2= o2.getPersonList();
//
//        Comparator<ReadOnlyAddressBook> studentComparator = Comparator.comparing(ReadOnlyAddressBook::toString);
//        ObservableList<ReadOnlyAddressBook> allStudentsWithStatus = FXCollections.observableArrayList();
//
////    Collections.sort(allStudentsWithStatus, studentComparator);
//
//        SortedList<ReadOnlyAddressBook> sortedStudents = new SortedList<>(allStudentsWithStatus, studentComparator);
//        logger.info("==== "+sortedStudents);
//
//        return 1;
//    }

    public static Comparator<Person> ascComparator = new Comparator<Person>() {

    @Override
    public int compare(Person o1, Person o2) {
        Name p1 = o1.getName();
        Name p2 = o2.getName();

        return p1.fullName.compareTo(p2.fullName);
    }

//        Comparator<ReadOnlyAddressBook> studentComparator = Comparator.comparing(ReadOnlyAddressBook::toString);
//        ObservableList<ReadOnlyAddressBook> allStudentsWithStatus = FXCollections.observableArrayList();
//        SortedList<ReadOnlyAddressBook> sortedStudents = new SortedList<>(allStudentsWithStatus, studentComparator);
//        logger.info("==== "+sortedStudents);
//
//        return 1;
//    }

//    public static Comparator<Person> ascComparator = new Comparator<Person>() {
//        @Override
//        public int compare(Person o1, Person o2) {
//            Name person1 = o1.getName();
//            Name person2 = o2.getName();
//
//            return person1.fullName.compareTo(person2.fullName);
//        }
    };


}
