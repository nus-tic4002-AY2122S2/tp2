package seedu.address.model.util;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
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
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {

    public static Person[] getSamplePersons() {
        return new Person[]{
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                    new Address("Blk 30 Geylang Street 29, #06-40"),
                    getTagSet("clients")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                    new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    getTagSet("clients", "VIP1")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                    new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    getTagSet("clients")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                    new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                    getTagSet("clients")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                    new Address("Blk 47 Tampines Street 20, #17-35"),
                    getTagSet("clients", "VIP2")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                    new Address("Blk 45 Aljunied Street 85, #11-31"),
                    getTagSet("clients", "inactive"))
        };
    }

    public static Post[] getSamplePosts() {
        return new Post[]{
            new Post(new Title("Important Notice：Warehouse Location changed in Guangzhou"),
                    new Content("Dear Customers, please notice that our ware house location changed to xx xxx xxxxx"),
                    new PostDate(LocalDateTime.of(2022, Month.MARCH, 18, 18, 0)),
                    new Category("notice"),
                    new Notes("send to all the clients, remember sent out by 18/03"),
                    getSendCidSet("Bernice Yu", "Irfan Ibrahim", "Alex Yeoh", "Charlotte Oliveiro", "David Li")
            ),
            new Post(new Title("Celebrate Our 6th Birthday with $6.6 OFF"),
                    new Content("Birthday Sales coming! Birthday goodies for everyone! "
                            + "Celebrate our Birthday with BEST Deals!"),
                    new PostDate(LocalDateTime.of(2022, Month.MARCH, 19, 6, 6)),
                    new Category("promotion"),
                    new Notes("remember sent out by 20/03, too all the registered client"),
                    getSendCidSet("Bernice Yu", "Irfan Ibrahim")
            ),
            new Post(new Title("[Notice] Drop in China Shipping Rate for all Sea shipment"),
                    new Content("Dear (Ship-For-Me) Customers, the adjustment on the rate will be "
                            + "$0.7/500g for Shanghai warehouse and $0.6/500g for Guangzhou warehouse, "
                            + "thanks for your support and hope to serve you again!"),
                    new PostDate(LocalDateTime.of(2022, Month.APRIL, 1, 9, 0)),
                    new Category("notice"),
                    new Notes("can not sent before the postdate, the shipping rate only start from April 1st"),
                    getSendCidSet()
            ),
            new Post(new Title("Your Parcel is ready to ship!"),
                    new Content("You order has already arrived our Guangzhou warehouse, "
                            + "please go our website to check : https://www.exampleshipment.sg , "
                            + "and remember the free storage period"),
                    new PostDate(LocalDateTime.of(2022, Month.FEBRUARY, 28, 18, 0)),
                    new Category("service"),
                    new Notes("remember sent out by 01/03"),
                    getSendCidSet("Bernice Yu")
            ),
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        for (Post samplePost : getSamplePosts()) {
            sampleAb.addPost(samplePost);
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
     * Returns a snet client id set containing the list of strings given.
     */
    public static Set<String> getSendCidSet(String... strings) {
        return Arrays.stream(strings)
                .collect(Collectors.toSet());
    }

}
