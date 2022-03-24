package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.LogicManager;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Birthday;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Edits the details of an existing person in the address book.
 */
public class RenameCommand extends Command {

    public static final String COMMAND_WORD = "rename";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": rename the tag of the person identified "
            + "by the existing tag in the displayed person list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: TAG (existing tag to rename) "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " g501 "
            + PREFIX_TAG + "g603 ";

    public static final String MESSAGE_RENAME_SUCCESS = "Rename is completed.";
    public static final String MESSAGE_NOT_RENAMED = "At least one field to rename must be provided.";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book.";

    private final EditPersonDescriptor editPersonDescriptor;
    private final Tag keyword;
    /**
     * @param editPersonDescriptor details to edit the person with
     * @param keyword tag to rename with
     */
    public RenameCommand(EditPersonDescriptor editPersonDescriptor, Tag keyword) {
        requireNonNull(editPersonDescriptor);
        requireNonNull(keyword);

        this.editPersonDescriptor = new EditPersonDescriptor(editPersonDescriptor);
        this.keyword = keyword;
    }

    @Override
    public CommandResult execute(Model model, ReadOnlyAddressBook originalAddressBook,
                                 String exCommand) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();
        int index;
        for (index = 0; index < lastShownList.size(); index++) {
            Person personToEdit = lastShownList.get(index);
            Person editedPerson = createEditedPerson(personToEdit, editPersonDescriptor, keyword);

            if (!personToEdit.isSamePerson(editedPerson) && model.hasPerson(editedPerson)) {
                throw new CommandException(MESSAGE_DUPLICATE_PERSON);
            }

            LogicManager.updateOriginalAddressBook(model.getAddressBook());

            model.setPerson(personToEdit, editedPerson);
            model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        }
        return new CommandResult(String.format(MESSAGE_RENAME_SUCCESS));
    }

    /**
     * Creates and returns a {@code Person} with the details of {@code personToEdit}
     * edited with {@code editPersonDescriptor}.
     */
    private static Person createEditedPerson(Person personToEdit, EditPersonDescriptor editPersonDescriptor, Tag key) {
        assert personToEdit != null;

        Name updatedName = editPersonDescriptor.getName().orElse(personToEdit.getName());
        Birthday updateBirthday = editPersonDescriptor.getBirthday().orElse(personToEdit.getBirthday());
        Phone updatedPhone = editPersonDescriptor.getPhone().orElse(personToEdit.getPhone());
        Email updatedEmail = editPersonDescriptor.getEmail().orElse(personToEdit.getEmail());
        Address updatedAddress = editPersonDescriptor.getAddress().orElse(personToEdit.getAddress());
        Set<Tag> updatedTags = editPersonDescriptor.getTags().orElse(personToEdit.getTags());
        Set<Tag> personTags = personToEdit.getTags();
        Set<Tag> copy = new HashSet<>();
        copy.addAll(updatedTags);
        copy.addAll(personTags);

        for (Tag temp:copy) {
            if (key.equals(temp)) {
                copy.remove(temp);
                return new Person(updatedName, updatedPhone, updatedEmail, updatedAddress, copy, updateBirthday);
            }
        }
        return new Person(updatedName, updatedPhone, updatedEmail, updatedAddress, personTags, updateBirthday);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditCommand)) {
            return false;
        }

        // state check
        RenameCommand e = (RenameCommand) other;
        return editPersonDescriptor.equals(e.editPersonDescriptor);
    }

    /**
     * Stores the details to edit the person with. Each non-empty field value will replace the
     * corresponding field value of the person.
     */
    public static class EditPersonDescriptor {
        private Name name;
        private Phone phone;
        private Email email;
        private Address address;
        private Set<Tag> tags;
        private Birthday birthday;

        public EditPersonDescriptor() {}



        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditPersonDescriptor(EditPersonDescriptor toCopy) {
            setName(toCopy.name);
            setPhone(toCopy.phone);
            setEmail(toCopy.email);
            setAddress(toCopy.address);
            setTags(toCopy.tags);
            setBirthday(toCopy.birthday);
        }

        /**
         * Returns true if tag is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(tags);
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Optional<Name> getName() {
            return Optional.ofNullable(name);
        }

        public void setPhone(Phone phone) {
            this.phone = phone;
        }

        public Optional<Phone> getPhone() {
            return Optional.ofNullable(phone);
        }

        public void setEmail(Email email) {
            this.email = email;
        }

        public Optional<Email> getEmail() {
            return Optional.ofNullable(email);
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public Optional<Address> getAddress() {
            return Optional.ofNullable(address);
        }

        public void setBirthday(Birthday birthday) {
            this.birthday = birthday;
        }

        public Optional<Birthday> getBirthday() {
            return Optional.ofNullable(birthday);
        }
        /**
         * Sets {@code tags} to this object's {@code tags}.
         * A defensive copy of {@code tags} is used internally.
         */
        public void setTags(Set<Tag> tags) {
            this.tags = (tags != null) ? new HashSet<>(tags) : null;
        }

        /**
         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code tags} is null.
         */
        public Optional<Set<Tag>> getTags() {
            return (tags != null) ? Optional.of(Collections.unmodifiableSet(tags)) : Optional.empty();
        }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditPersonDescriptor)) {
                return false;
            }

            // state check
            EditPersonDescriptor e = (EditPersonDescriptor) other;

            return getTags().equals(e.getTags());
        }
    }
}
