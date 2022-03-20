package seedu.address.logic.commands;


import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.post.Post;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

public class SendCommand extends Command {

    public static final String COMMAND_WORD = "send";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Send the post to client(s) ";

    public static final String MESSAGE_SUCCESS = "Sent successfully";

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
        for (Index cIdx : clientIdx){
            if (cIdx.getZeroBased() >= lastShownClientList.size()) {
                throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
            }else {
                selectedClientName.add(lastShownClientList.get(cIdx.getZeroBased()).getName().fullName);
            }
        }

        for (Index pIdx : postIdx) {
            if (pIdx.getZeroBased() >= lastShownPostList.size()) {
                throw new CommandException(Messages.MESSAGE_INVALID_POST_DISPLAYED_INDEX);
            } else {
                Set<String> currentSentClient = lastShownPostList.get(pIdx.getZeroBased()).getSentCid();
                currentSentClient.addAll(selectedClientName);
                model.updatePostSentCid(currentSentClient, lastShownPostList.get(pIdx.getZeroBased()));
            }
        }
        model.updateFilteredPostList(Model.PREDICATE_SHOW_ALL_POSTS);
        System.out.println("this is a send command\n");
        System.out.println("clientidx: " + clientIdx + " postIdx: " + postIdx);

        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }




}
