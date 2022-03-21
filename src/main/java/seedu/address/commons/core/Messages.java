package seedu.address.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_INVALID_POST_DISPLAYED_INDEX = "The post index provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";

    public static final String MESSAGE_POST_SENT_TO_DUPLICATE_CLIENT_ALL =
            "Warning: This post \n%1$s\n has already sent to all the clients you selected! "
                    + "Please choose other clients ";
    public static final String MESSAGE_POST_SENT_TO_DUPLICATE_CLIENT =
            "This post \n%1$s\n has already sent to these clients : \n%2$s\n, "
                    + "these clients will not receive this post, "
                    + "the system will send the post to the rest clients you selected";

}
