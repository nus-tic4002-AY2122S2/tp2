package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.DateJoined;
import seedu.address.model.person.Email;
import seedu.address.model.person.Log;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_DATEJOINED = "15/12/2001";
    public static final String DEFAULT_REMARK = "";
    public static final String DEFAULT_LOG = "";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private DateJoined dateJoined;
    private Remark remark;

    private Log log;

    private Set<Tag> tags;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        dateJoined = new DateJoined(DEFAULT_DATEJOINED);
        remark = new Remark(DEFAULT_REMARK);
        log = new Log(DEFAULT_LOG);
        tags = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        dateJoined = personToCopy.getDateJoined();
        remark = personToCopy.getRemark();
        log = personToCopy.getLog();
        tags = new HashSet<>(personToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Log} of the {@code Person} that we are building.
     */
    public PersonBuilder withLog(String remark) {
        this.log = new Log(remark);
        return this;
    }

    /**
     * Sets the {@code DateJoined} of the {@code Person} that we are building.
     */
    public PersonBuilder withDateJoined(String dateJoined) {
        this.dateJoined = new DateJoined(dateJoined);
        return this;
    }

    public Person build() {
        return new Person(name, phone, email, address, dateJoined, remark, log, tags);
    }
}
