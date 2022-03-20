package seedu.address.model.person;

import seedu.address.model.tag.Tag;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Address address;
    private final Classroom classroom;
    private final Set<Tag> tags = new HashSet<>();

    // Subject grade
    private final English english;
    private final MotherTongue motherTongue;
    private final Mathematics mathematics;
    private final Science science;

    // Receive type
    private final ReceiveType receiveType;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, Classroom classroom,
                  English english, MotherTongue motherTongue, Mathematics mathematics,
                  Science science, ReceiveType receiveType, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, english, motherTongue, mathematics, science, receiveType, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.classroom = classroom;
        this.english = english;
        this.motherTongue = motherTongue;
        this.mathematics = mathematics;
        this.science = science;
        this.receiveType = receiveType;
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public English getEnglish() {
        return english;
    }

    public MotherTongue getMotherTongue() {
        return motherTongue;
    }

    public Mathematics getMathematics() {
        return mathematics;
    }

    public Science getScience() {
        return science;
    }

    public ReceiveType getReceiveType(){
        return receiveType;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getName().equals(getName())
                && otherPerson.getPhone().equals(getPhone())
                && otherPerson.getEmail().equals(getEmail())
                && otherPerson.getAddress().equals(getAddress())
                && otherPerson.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, receiveType, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Email: ")
                .append(getEmail())
                .append("; Address: ")
                .append(getAddress())
                .append("; Classroom: ")
                .append(getClassroom())
                .append("; English: ")
                .append(getEnglish())
                .append("; MotherTongue: ")
                .append(getMotherTongue())
                .append("; Mathematics: ")
                .append(getMathematics())
                .append("; Science: ")
                .append(getScience())
                .append("; ReceiveType: ")
                .append(getReceiveType());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }


}
