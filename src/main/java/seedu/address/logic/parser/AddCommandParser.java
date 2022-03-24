package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CATEGORY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CONTENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTES;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_POSTDATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;
import static seedu.address.logic.parser.CommonRegexPattern.BASIC_TYPE_FORMAT;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.stream.Stream;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ListType;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.post.Category;
import seedu.address.model.post.Content;
import seedu.address.model.post.Notes;
import seedu.address.model.post.Post;
import seedu.address.model.post.PostDate;
import seedu.address.model.post.Title;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {

        final Matcher matcherType = BASIC_TYPE_FORMAT.matcher(args.trim());
        ListType listType;
        String args1;

        if (matcherType.matches()) {
            listType = (!(matcherType.group("isClient") == null)
                    && !(matcherType.group("isClient").isEmpty())) ? ListType.CLIENT
                    : (!(matcherType.group("isPost") == null)
                    && !(matcherType.group("isPost").isEmpty())) ? ListType.POST : null;
            args1 = matcherType.group("args");

            if (listType == ListType.CLIENT) {

                ArgumentMultimap argMultimap =
                        ArgumentTokenizer.tokenize(args1, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL,
                                PREFIX_ADDRESS, PREFIX_TAG);

                if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_ADDRESS, PREFIX_PHONE, PREFIX_EMAIL)
                        || !argMultimap.getPreamble().isEmpty()) {
                    throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
                }

                Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
                Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
                Email email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get());
                Address address = ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get());
                Set<Tag> tagList = ParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG));

                Person person = new Person(name, phone, email, address, tagList);

                return new AddCommand(person);

            } else if (listType == ListType.POST) {

                ArgumentMultimap argMultimap =
                        ArgumentTokenizer.tokenize(args1, PREFIX_TITLE, PREFIX_CONTENT, PREFIX_POSTDATE,
                                PREFIX_CATEGORY, PREFIX_NOTES);

                if (!arePrefixesPresent(argMultimap, PREFIX_TITLE, PREFIX_CONTENT, PREFIX_POSTDATE,
                        PREFIX_CATEGORY, PREFIX_NOTES)
                        || !argMultimap.getPreamble().isEmpty()) {
                    throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
                }

                Title title = new Title(argMultimap.getValue(PREFIX_TITLE).get());
                Content content = new Content(argMultimap.getValue(PREFIX_CONTENT).get());
                PostDate postDate = ParserUtil.parsePostDate(argMultimap.getValue(PREFIX_POSTDATE).get());
                Category category = new Category(argMultimap.getValue(PREFIX_CATEGORY).get());
                Notes notes = new Notes(argMultimap.getValue(PREFIX_NOTES).get());

                Post post = new Post(title, content, postDate, category, notes, new HashSet<>());

                return new AddCommand(post);
            } else {
                throw new ParseException("You need declare client or post you want to add, "
                        + "the second parameter can only be client|c or post|p");
            }
        } else {
            throw new ParseException("You need declare client or post you want to add");
        }

    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
