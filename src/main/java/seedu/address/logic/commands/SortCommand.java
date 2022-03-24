package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.post.Post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sort the list by postdate";

    private String keyword;
    private String order;

    /**
     * Creates an SortCommand to sort the list
     */
    public SortCommand(String keyword, String order) {
        this.keyword = keyword;
        this.order = order;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Post> lastShownPostList = model.getFilteredPostList();
        if (lastShownPostList.size() == 0) {
            throw new CommandException(Messages.MESSAGE_EMPTY_LIST_ERROR);
        }

        List<Post> lastShownPostListCopy = new ArrayList<>();
        lastShownPostListCopy.addAll(lastShownPostList);

        switch (keyword) {
            case "postdate":
            default: {
                if (order.equals("asc")) {
                    Collections.sort(lastShownPostListCopy, (t1, t2) -> {
                        if (t1.getPostDate().value.isBefore(t2.getPostDate().value)) {
                            return -1;
                        } else {
                            return 1;
                        }
                    });
                } else {
                    Collections.sort(lastShownPostListCopy, (t1, t2) -> {
                        if (t1.getPostDate().value.isAfter(t2.getPostDate().value)) {
                            return -1;
                        } else {
                            return 1;
                        }
                    });

                }
            }

        }
        model.updateWholePostList(lastShownPostListCopy);

        model.updateFilteredPostList(Model.PREDICATE_SHOW_ALL_POSTS);
        return new CommandResult("success");
    }

}
