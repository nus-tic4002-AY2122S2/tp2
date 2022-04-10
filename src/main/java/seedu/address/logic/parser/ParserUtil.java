package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Classroom;
import seedu.address.model.person.Email;
import seedu.address.model.person.English;
import seedu.address.model.person.Mathematics;
import seedu.address.model.person.MotherTongue;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Science;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String classroom} into an {@code classroom}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code classroom} is invalid.
     */
    public static Classroom parseClassroom(String classroom) throws ParseException {
        requireNonNull(classroom);
        String trimmedClassroom = classroom.trim();
        return new Classroom(trimmedClassroom);
    }

    /**
     * Parses a {@code String english} into an {@code english}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code english} is invalid.
     */
    public static English parseEnglish(String english) throws ParseException {
        requireNonNull(english);
        String trimmedEnglish = english.trim();
        return new English(Integer.parseInt(trimmedEnglish));
    }

    /**
     * Parses a {@code String motherTongue} into an {@code motherTongue}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code motherTongue} is invalid.
     */
    public static MotherTongue parseMotherTongue(String motherTongue) throws ParseException {
        requireNonNull(motherTongue);
        String trimmedMotherTongue = motherTongue.trim();
        return new MotherTongue(Integer.parseInt(trimmedMotherTongue));
    }

    /**
     * Parses a {@code String mathematics} into an {@code mathematics}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code mathematics} is invalid.
     */
    public static Mathematics parseMathematics(String mathematics) throws ParseException {
        requireNonNull(mathematics);
        String trimmedMathematics = mathematics.trim();
        return new Mathematics(Integer.parseInt(trimmedMathematics));
    }

    /**
     * Parses a {@code String science} into an {@code science}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code science} is invalid.
     */
    public static Science parseScience(String science) throws ParseException {
        requireNonNull(science);
        String trimmedScience = science.trim();
        return new Science(Integer.parseInt(trimmedScience));
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

}
