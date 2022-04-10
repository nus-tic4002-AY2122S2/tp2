package seedu.address.testutil;

import seedu.address.model.GreatBook;
import seedu.address.model.person.Person;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private GreatBook greatBook;

    public AddressBookBuilder() {
        greatBook = new GreatBook();
    }

    public AddressBookBuilder(GreatBook greatBook) {
        this.greatBook = greatBook;
    }

    /**
     * Adds a new {@code Person} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withPerson(Person person) {
        greatBook.addPerson(person);
        return this;
    }

    public GreatBook build() {
        return greatBook;
    }
}
