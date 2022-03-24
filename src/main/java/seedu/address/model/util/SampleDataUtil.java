package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Birthday;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Relation;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Sheryl Lim"), new Phone("91917777"), new Email("slim@stu.school.edu"),
                new Address("Blk 04 City View, #30-106"),
                getTagSet("g501", "student"), new Birthday("2012-01-10"), getRelation("David Lim")),
            new Person(new Name("David Lim"), new Phone("91917777"), new Email("dlim@lim.com"),
                new Address("Blk 04 City View, #30-106"),
                getTagSet("parent"), new Birthday("1980-12-25"), getRelation("Sheryl Lim")),
            new Person(new Name("May Parker"), new Phone("66662222"), new Email("mparker@stf.school.edu"),
                new Address("Blk 065 Sim St, #97-02 - test a longer address, for example - "
                        + "New Queen District, New New York, New US, Mars. Post Code 110-555-650"),
                getTagSet("teacher", "g501", "g503"), new Birthday("1970-05-05")),
            new Person(new Name("Ben Williams"), new Phone("66662121"), new Email("bwill@stf.school.edu"),
                new Address("Blk 43 Tensor Rd, #10-322"),
                getTagSet("teacher", "g501", "g503"), new Birthday("1998-01-02")),
            new Person(new Name("Ruby Rose"), new Phone("90901111"), new Email("rrose@stu.school.edu"),
                new Address("Blk 109 Garden View, #22-04"),
                getTagSet("g501", "student"), new Birthday("2012-01-04")),
            new Person(new Name("Winter Rose"), new Phone("90904444"), new Email("wrose@rose.com"),
                new Address("Blk 109 Garden View, #22-04"),
                getTagSet("parent"), new Birthday("1984-11-15")),
            new Person(new Name("June Lim"), new Phone("96005555"), new Email("jlim@stu.school.edu"),
                    new Address("Blk 07 City View, #10-304"),
                    getTagSet("g501", "student"), new Birthday("2012-04-01")),
            new Person(new Name("Summer Lim"), new Phone("96008888"), new Email("summer@apple.com"),
                    new Address("Blk 07 City View, #10-304"),
                    getTagSet("parent"), new Birthday("1982-09-09")),
            new Person(new Name("Steve Wong"), new Phone("90093003"), new Email("steve@stu.school.edu"),
                    new Address("Blk 225C River View, #07-01"),
                    getTagSet("student", "g503"), new Birthday("2012-03-03"), getRelation("Ada Wong")),
            new Person(new Name("Ada Wong"), new Phone("90093003"), new Email("ada@umbrella.corp"),
                    new Address("Blk 225C River View, #07-01"),
                    getTagSet("parent"), new Birthday("1990-02-02"), getRelation("Steve Wong")),
            new Person(new Name("Raja Mankumar"), new Phone("90904545"), new Email("raja@stu.school.edu"),
                    new Address("Blk 225A River View, #04-06"),
                    getTagSet("student", "g503"), new Birthday("2012-07-07")),
            new Person(new Name("Kamya Mankumar"), new Phone("90900101"), new Email("kamya@google.com"),
                    new Address("Blk 223A River View, #04-06"),
                    getTagSet("parent"), new Birthday("1978-10-10")),
            new Person(new Name("Bon John"), new Phone("92224777"), new Email("bjohn@stu.school.edu"),
                    new Address("Blk 15 Coast View, #10-422"),
                    getTagSet("student", "g602"), new Birthday("2011-06-06"), getRelation("Susan Ng")),
            new Person(new Name("Elton John"), new Phone("92224000"), new Email("ejohn@stf.school.edu"),
                    new Address("Blk 45 Aljunied Street 85, #11-31"),
                    getTagSet("parent", "teacher", "g602"), new Birthday("1976-11-11")),
            new Person(new Name("Kamiya Yui"), new Phone("92340678"), new Email("yui@stu.school.edu"),
                    new Address("Blk 72 Herb Land, #24-02"),
                    getTagSet("student", "g602"), new Birthday("2011-05-25"), getRelation("Susan Ng")),
            new Person(new Name("Kamiya Rei"), new Phone("92340678"), new Email("rei@nintendo.jp"),
                    new Address("Blk 72 Herb Land, #24-02"),
                    getTagSet("parent"), new Birthday("1986-08-08")),
            new Person(new Name("Susan Ng"), new Phone("66662224"), new Email("sng@stf.school.edu"),
                    new Address("Blk 22 East Drive, #01-08"),
                    getTagSet("teacher", "g602"), new Birthday("1991-03-12"), getRelation("Bon John", "Kamiya Yui")),
            new Person(new Name("Simon Lim"), new Phone("66880022"), new Email("sales@paper.com"),
                    new Address("No.80 Inno Park"),
                    getTagSet("supplier"), new Birthday("1988-01-30")),
            new Person(new Name("Anna Peach"), new Phone("80023344"), new Email("ap@cdb.com"),
                    new Address("101 CDB, #50-01"),
                    getTagSet("supplier"), new Birthday("1990-06-06")),
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
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
    /**
     * Returns a Relation containing the list of strings given.
     */
    public static Relation getRelation(String... strings) {
        return new Relation(Arrays.stream(strings)
                .map(Name::new)
                .collect(Collectors.toList()));
    }

}
