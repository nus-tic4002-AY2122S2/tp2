package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;
import java.util.Set;

import javafx.collections.ObservableList;
import seedu.address.model.person.Person;
import seedu.address.model.person.UniquePersonList;
import seedu.address.model.post.Post;
import seedu.address.model.post.UniquePostList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class AddressBook implements ReadOnlyAddressBook {

    private final UniquePersonList persons;
    private final UniquePostList posts;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        persons = new UniquePersonList();
        posts = new UniquePostList();
    }

    public AddressBook() {}

    /**
     * Creates an AddressBook using the Persons and posts in the {@code toBeCopied}
     */
    public AddressBook(ReadOnlyAddressBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setPersons(List<Person> persons) {
        this.persons.setPersons(persons);
    }

    /**
     * Replaces the contents of the post list with {@code posts}.
     * {@code posts} must not contain duplicate posts.
     */
    public void setPosts(List<Post> posts) {
        this.posts.setPosts(posts);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyAddressBook newData) {
        requireNonNull(newData);

        setPersons(newData.getPersonList());
        setPosts(newData.getPostList());
    }

    //// person-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasPerson(Person person) {
        requireNonNull(person);
        return persons.contains(person);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addPerson(Person p) {
        persons.add(p);
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    public void setPerson(Person target, Person editedPerson) {
        requireNonNull(editedPerson);

        persons.setPerson(target, editedPerson);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removePerson(Person key) {
        persons.remove(key);
    }

    /**
     * Removes {@code keys} from this {@code AddressBook}.
     * {@code keys} must exist in the address book.
     */
    public void removePersonAll(List<Person> keys) {
        persons.removeAll(keys);
    }


    //// post-level operations

    /**
     * Returns true if a post with the same identity as {@code post} exists in the address book.
     */
    public boolean hasPost(Post post) {
        requireNonNull(post);
        return posts.contains(post);
    }

    /**
     * Adds a post to the address book.
     * The post must not already exist in the address book.
     */
    public void addPost(Post p) {
        posts.add(p);
    }

    /**
     * Replaces the given post {@code target} in the list with {@code editedPost}.
     * {@code target} must exist in the address book.
     * The post identity of {@code editedPerson} must not be the same as another existing post in the address book.
     */
    public void setPost(Post target, Post editedPost) {
        requireNonNull(editedPost);

        posts.setPost(target, editedPost);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removePost(Post key) {
        posts.remove(key);
    }

    /**
     * Removes {@code keys} from this {@code AddressBook}.
     * {@code keys} must exist in the address book.
     */
    public void removePostAll(List<Post> keys) {
        posts.removeAll(keys);
    }

    /**
     * Update the {@code targetPost} original sent out client id set based on {@code updatedSentCid} set
     * The updatedSentCid and targetPost must be declared.
     */
    public void updatePostSentCid(Set<String> updatedSentCid, Post targetPost) {
        requireAllNonNull(updatedSentCid, targetPost);
        posts.updatePostSentCid(updatedSentCid, targetPost);
    }

    /**
     * Clear all the items in the {@code UniquePostList} from this {@code AddressBook}.
     */
    public void clearPostList() {
        posts.clear();
    }

    /**
     * Adds the entire source post list to the {@code UniquePostList}
     * @param postList the source post list
     */
    public void addAllPosts(List<Post> postList) {
        posts.addAllPosts(postList);
    }

    //// util methods

    @Override
    public String toString() {
        return persons.asUnmodifiableObservableList().size() + " persons";
        // TODO: refine later
    }

    @Override
    public ObservableList<Person> getPersonList() {
        return persons.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Post> getPostList() {
        return posts.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressBook // instanceof handles nulls
                && persons.equals(((AddressBook) other).persons) && posts.equals(((AddressBook) other).posts));
    }

    @Override
    public int hashCode() {
        return persons.hashCode();
        // TODO: refine later
    }

}
