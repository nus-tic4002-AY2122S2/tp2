package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_POSTS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.post.Post;


public class SendCommand extends Command {

    public static final String COMMAND_WORD = "send";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Send the post to client(s) ";

    public static final String MESSAGE_SUCCESS = "Sent the selected post %1$s successfully to the client %2$s";

    private List<Index> clientIdx = new ArrayList<>();
    private List<Index> postIdx = new ArrayList<>();

    /**
     * Creates an SendCommand to send the post(s) to the client(s)
     */
    public SendCommand(List<Index> clientIdx, List<Index> postIdx) {
        this.clientIdx.addAll(clientIdx);
        this.postIdx.addAll(postIdx);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownClientList = model.getFilteredPersonList();
        List<Post> lastShownPostList = model.getFilteredPostList();
        Set<String> selectedClientName = new HashSet<>();
        Set<String> selectedPostTitle = new HashSet<>();
        for (Index cIdx : clientIdx) {
            if (cIdx.getZeroBased() >= lastShownClientList.size()) {
                throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
            } else {
                selectedClientName.add(lastShownClientList.get(cIdx.getZeroBased()).getName().fullName);
            }
        }

        String outputMsg = "";
        for (Index pIdx : postIdx) {
            if (pIdx.getZeroBased() >= lastShownPostList.size()) {
                throw new CommandException(Messages.MESSAGE_INVALID_POST_DISPLAYED_INDEX);
            } else {
                Post targetPost = lastShownPostList.get(pIdx.getZeroBased());
                selectedPostTitle.add(targetPost.getTitle().value);
                Set<String> currentSentClient = targetPost.getSentCid();

                Set<String> unSentClientName = new HashSet<>();
                Set<String> restClientName = new HashSet<>();
                unSentClientName.addAll(selectedClientName);
                restClientName.addAll(selectedClientName);
                unSentClientName.removeAll(currentSentClient);
                restClientName.removeAll(unSentClientName);
                if (unSentClientName.size() == 0) {
                    outputMsg += String.format(
                            Messages.MESSAGE_POST_SENT_TO_DUPLICATE_CLIENT_ALL, targetPost.getTitle().value) + "\n";
                } else if (unSentClientName.size() < selectedClientName.size()) {
                    outputMsg += String.format(
                            Messages.MESSAGE_POST_SENT_TO_DUPLICATE_CLIENT,
                            targetPost.getTitle().value, restClientName.toString()) + "\n";
                } else {
                    outputMsg += String.format(
                            MESSAGE_SUCCESS, targetPost.toString(), selectedClientName.toString()) + "\n";
                }
                //currentSentClient.addAll(selectedClientName);
                currentSentClient.addAll(unSentClientName);
                model.updatePostSentCid(currentSentClient, targetPost);
                //model.updateFilteredPostList(PREDICATE_SHOW_ALL_POSTS);

            }
        }
        model.updateFilteredPostList(PREDICATE_SHOW_ALL_POSTS);
        //return new CommandResult(
        //       String.format(MESSAGE_SUCCESS, selectedPostTitle.toString(), selectedClientName.toString()));
        return new CommandResult(outputMsg);
    }


}
