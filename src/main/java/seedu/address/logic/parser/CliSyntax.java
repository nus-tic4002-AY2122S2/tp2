package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Person Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    /* Post Prefix definitions */
    public static final Prefix PREFIX_TITLE = new Prefix("t/");
    public static final Prefix PREFIX_CONTENT = new Prefix("c/");
    public static final Prefix PREFIX_POSTDATE = new Prefix("p/");
    public static final Prefix PREFIX_CATEGORY = new Prefix("ca/");
    public static final Prefix PREFIX_NOTES = new Prefix("n/");


    /* SendCommand Prefix */
    public static final Prefix SEND_PREFIX_CLIENT = new Prefix("c/");
    public static final Prefix SEND_PREFIX_POST = new Prefix("p/");
}
