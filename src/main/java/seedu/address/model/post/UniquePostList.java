package seedu.address.model.post;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.post.exceptions.DuplicatePostException;
import seedu.address.model.post.exceptions.PostNotFoundException;


public class UniquePostList implements Iterable<Post> {

    private final ObservableList<Post> internalList = FXCollections.observableArrayList();
    private final ObservableList<Post> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent post as the given argument.
     */
    public boolean contains(Post toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSamePost);
    }

    /**
     * Adds a post to the post list.
     * The post must not already exist in the list.
     */
    public void add(Post toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicatePostException();
        }
        internalList.add(toAdd);
    }

    /**
     * Replaces the post {@code target} in the post list with {@code editedPost}.
     * {@code target} must exist in the post list.
     * The post identity of {@code editedPost} must not be the same as another existing post in the list.
     */
    public void setPost(Post target, Post editedPost) {
        requireAllNonNull(target, editedPost);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new PostNotFoundException();
        }

        if (!target.isSamePost(editedPost) && contains(editedPost)) {
            throw new DuplicatePostException();
        }

        internalList.set(index, editedPost);
    }

    /**
     * Removes the equivalent post from the list.
     * The post must exist in the list.
     */
    public void remove(Post toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new PostNotFoundException();
        }
    }

    /**
     * Removes the post list from the main list.
     */
    public void removeAll(List<Post> toRemove) {
        requireNonNull(toRemove);
        if (!internalList.removeAll(toRemove)) {
            throw new PostNotFoundException();
        }
    }

    public void setPosts(UniquePostList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code posts}.
     * {@code posts} must not contain duplicate posts.
     */
    public void setPosts(List<Post> posts) {
        requireAllNonNull(posts);
        if (!postsAreUnique(posts)) {
            throw new DuplicatePostException();
        }

        internalList.setAll(posts);
    }

    /**
     * Update the {@code targetPost} original sent out client id set based on {@code updatedSentCid} set
     * The updatedSentCid and targetPost must be declared.
     */
    public void updatePostSentCid(Set<String> updatedSentCid, Post targetPost) {
        requireAllNonNull(targetPost, updatedSentCid);

        int index = internalList.indexOf(targetPost);
        if (index == -1) {
            throw new PostNotFoundException();
        }

        // Can not directly update the sent client id
        // otherwise the javafx not able to refresh the post list successfully although the json updated
        // must set the whole post object

        //internalList.get(index).updateSentCid(updatedSentCid);
        Post postCopy = targetPost;
        postCopy.updateSentCid(updatedSentCid);
        internalList.set(index, postCopy);

    }

    public void clear() {
        internalList.clear();
    }

    public void addAllPosts(List<Post> postList) {
        internalList.addAll(postList);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Post> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Post> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniquePostList // instanceof handles nulls
                && internalList.equals(((UniquePostList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    /**
     * Returns true if {@code posts} contains only unique posts.
     */
    private boolean postsAreUnique(List<Post> posts) {
        for (int i = 0; i < posts.size() - 1; i++) {
            for (int j = i + 1; j < posts.size(); j++) {
                if (posts.get(i).isSamePost(posts.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }


}
