package seedu.address.model.util;

import seedu.address.model.GreatBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"), new Classroom("1A"), new English(80),
                    new MotherTongue(85), new Mathematics(70), new Science(65), new ReceiveType("sms"), getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), new Classroom("1A"), new English(95),
                    new MotherTongue(88), new Mathematics(98), new Science(99), new ReceiveType("email"), getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), new Classroom("1A"), new English(67),
                    new MotherTongue(98), new Mathematics(100), new Science(97), new ReceiveType("sms"), getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), new Classroom("1A"), new English(90),
                    new MotherTongue(92), new Mathematics(84), new Science(86), new ReceiveType("email"), getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"), new Classroom("1A"), new English(79),
                    new MotherTongue(86), new Mathematics(88), new Science(79), new ReceiveType("sms"), getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"), new Classroom("1A"), new English(92),
                    new MotherTongue(98), new Mathematics(94), new Science(86), new ReceiveType("email"), getTagSet("colleagues"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        GreatBook sampleAb = new GreatBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
