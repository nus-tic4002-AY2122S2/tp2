package seedu.address.model;

import java.util.ArrayList;

/**
 * Advanced version of AddressBook which includes commit, undo and redo feature.
 */
public class VersionedAddressBook extends AddressBook {
    private ArrayList<AddressBook> addressBookStateList;
    private int currentStatePointer;

    /**
     * Initializes a VersionedAddressBook with the initialData provided.
     */
    public VersionedAddressBook() {
        super();
        this.currentStatePointer = 0;
    }

    /**
     * Initializes a VersionedAddressBook with the provided ReadOnlyAddressBook argument.
     */
    public VersionedAddressBook(ReadOnlyAddressBook toBeCopied) {
        super(toBeCopied);
        this.currentStatePointer = 0;
        AddressBook newCopy = new AddressBook(toBeCopied);
        this.addressBookStateList = new ArrayList<>();
        this.addressBookStateList.add(newCopy);
    }

    /**
     * Commits the latest AddressBook state to a list.
     */
    public void commit(ReadOnlyAddressBook toBeCommitted) {
        this.addressBookStateList.add(new AddressBook(toBeCommitted));
        this.currentStatePointer = addressBookStateList.size() - 1;
        this.addressBookStateList.subList(this.currentStatePointer + 1, this.addressBookStateList.size());
    }

    /**
     * Undo the latest commit stored in history.
     * Returns true if there is a commit to undo.
     */
    public boolean undo() {
        if (currentStatePointer == 0) {
            return false;
        } else {
            super.resetData(this.addressBookStateList.get(this.currentStatePointer - 1));
            this.currentStatePointer -= 1;
            return true;
        }
    }

    /**
     * Restores a previously undone address book state history.
     * Returns true of there is a commit to redo.
     */
    public boolean redo() {
        if (this.currentStatePointer == this.addressBookStateList.size() - 1) {
            return false;
        } else {
            super.resetData(this.addressBookStateList.get(this.currentStatePointer + 1));
            this.currentStatePointer += 1;
            return true;
        }
    }
}