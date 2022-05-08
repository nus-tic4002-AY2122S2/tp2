package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
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

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.EditContentDescriptor;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ListType;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditCommandParser implements Parser<EditCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String args) throws ParseException {
        requireNonNull(args);

        Matcher matcherType = BASIC_TYPE_FORMAT.matcher(args.trim());
        ListType listType;

        if (matcherType.matches()) {
            listType = (!(matcherType.group("isClient") == null)
                && !(matcherType.group("isClient").isEmpty())) ? ListType.CLIENT
                : (!(matcherType.group("isPost") == null)
                && !(matcherType.group("isPost").isEmpty())) ? ListType.POST : null;
            args = matcherType.group("args");

            if (listType == ListType.CLIENT) {

                ArgumentMultimap argMultimap =
                    ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL,
                        PREFIX_ADDRESS, PREFIX_TAG);

                Index index;

                try {
                    index = ParserUtil.parseIndex(argMultimap.getPreamble());
                }
                catch (ParseException pe) {
                    throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                        EditCommand.MESSAGE_USAGE), pe);
                }

                EditPersonDescriptor editPersonDescriptor = new EditPersonDescriptor();
                if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
                    editPersonDescriptor.setName(ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get()));
                }
                if (argMultimap.getValue(PREFIX_PHONE).isPresent()) {
                    editPersonDescriptor.setPhone(ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get()));
                }
                if (argMultimap.getValue(PREFIX_EMAIL).isPresent()) {
                    editPersonDescriptor.setEmail(ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get()));
                }
                if (argMultimap.getValue(PREFIX_ADDRESS).isPresent()) {
                    editPersonDescriptor.setAddress(
                        ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get()));
                }
                parseTagsForEdit(argMultimap.getAllValues(PREFIX_TAG)).ifPresent(editPersonDescriptor::setTags);

                if (!editPersonDescriptor.isAnyFieldEdited()) {
                    throw new ParseException(EditCommand.MESSAGE_NOT_EDITED);
                }

                return new EditCommand(index, editPersonDescriptor);

            } else if (listType == ListType.POST) {

                ArgumentMultimap argMultimap =
                    ArgumentTokenizer.tokenize(args, PREFIX_TITLE, PREFIX_CONTENT, PREFIX_POSTDATE,
                        PREFIX_CATEGORY, PREFIX_NOTES);

                Index index;

                try {
                    index = ParserUtil.parseIndex(argMultimap.getPreamble());
                }
                catch (ParseException pe) {
                    throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                        EditCommand.MESSAGE_USAGE_2), pe);
                }

                EditContentDescriptor editContentDescriptor = new EditContentDescriptor();
                if (argMultimap.getValue(PREFIX_TITLE).isPresent()) {
                    editContentDescriptor.setTitle(ParserUtil.parseTitle(argMultimap.getValue(PREFIX_TITLE).get()));
                }
                if (argMultimap.getValue(PREFIX_CONTENT).isPresent()) {
                    editContentDescriptor.setContent(
                        ParserUtil.parseContent(argMultimap.getValue(PREFIX_CONTENT).get()));
                }
                if (argMultimap.getValue(PREFIX_POSTDATE).isPresent()) {
                    editContentDescriptor.setPostDate(
                        ParserUtil.parsePostDate(argMultimap.getValue(PREFIX_POSTDATE).get()));
                }
                if (argMultimap.getValue(PREFIX_CATEGORY).isPresent()) {
                    editContentDescriptor.setCategory(
                        ParserUtil.parseCategory(argMultimap.getValue(PREFIX_CATEGORY).get()));
                }
                if (argMultimap.getValue(PREFIX_NOTES).isPresent()) {
                    editContentDescriptor.setNotes(ParserUtil.parseNotes(argMultimap.getValue(PREFIX_NOTES).get()));
                }
                if (!editContentDescriptor.isAnyFieldEdited()) {
                    throw new ParseException(EditCommand.MESSAGE_NOT_EDITED);
                }
                return new EditCommand(index, editContentDescriptor);
            } else {
                throw new ParseException("You need declare client or post you want to add, "
                    + "the second parameter can only be client|c or post|p");
            }
        } else {
            throw new ParseException("You need declare client or post you want to add");
        }
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>} if {@code tags} is non-empty.
     * If {@code tags} contain only one element which is an empty string, it will be parsed into a
     * {@code Set<Tag>} containing zero tags.
     */
    private Optional<Set<Tag>> parseTagsForEdit(Collection<String> tags) throws ParseException {
        assert tags != null;

        if (tags.isEmpty()) {
            return Optional.empty();
        }
        Collection<String> tagSet = tags.size() == 1 && tags.contains("") ? Collections.emptySet() : tags;
        return Optional.of(ParserUtil.parseTags(tagSet));
    }

}
