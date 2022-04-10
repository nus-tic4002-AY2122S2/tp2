package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Classroom;
import seedu.address.model.person.Email;
import seedu.address.model.person.English;
import seedu.address.model.person.Mathematics;
import seedu.address.model.person.MotherTongue;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Science;
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
    public static final String DEFAULT_CLASSROOM = "1A";
    public static final String DEFAULT_ENGLISH = "90";
    public static final String DEFAULT_MOTHERTONGUE = "90";
    public static final String DEFAULT_MATHEMATICS = "90";
    public static final String DEFAULT_SCIENCE = "90";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Classroom classroom;
    private English english;
    private MotherTongue motherTongue;
    private Mathematics mathematics;
    private Science science;
    private Set<Tag> tags;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        classroom = new Classroom(DEFAULT_CLASSROOM);
        english = new English(Integer.parseInt(DEFAULT_ENGLISH));
        motherTongue = new MotherTongue(Integer.parseInt(DEFAULT_MOTHERTONGUE));
        mathematics = new Mathematics(Integer.parseInt(DEFAULT_MATHEMATICS));
        science = new Science(Integer.parseInt(DEFAULT_SCIENCE));
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
        classroom = personToCopy.getClassroom();
        english = personToCopy.getEnglish();
        motherTongue = personToCopy.getMotherTongue();
        mathematics = personToCopy.getMathematics();
        science = personToCopy.getScience();
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
     * Sets the {@code Classroom} of the {@code Person} that we are building.
     */
    public PersonBuilder withClassroom(String classroom) {
        this.classroom = new Classroom(classroom);
        return this;
    }

    /**
     * Sets the {@code English} of the {@code Person} that we are building.
     */
    public PersonBuilder withEnglish(String english) {
        this.english = new English(Integer.parseInt(english));
        return this;
    }

    /**
     * Sets the {@code MotherTongue} of the {@code Person} that we are building.
     */
    public PersonBuilder withMotherTongue(String motherTongue) {
        this.motherTongue = new MotherTongue(Integer.parseInt(motherTongue));
        return this;
    }

    /**
     * Sets the {@code Mathematics} of the {@code Person} that we are building.
     */
    public PersonBuilder withMathematics(String mathematics) {
        this.mathematics = new Mathematics(Integer.parseInt(mathematics));
        return this;
    }

    /**
     * Sets the {@code Science} of the {@code Person} that we are building.
     */
    public PersonBuilder withScience(String science) {
        this.science = new Science(Integer.parseInt(science));
        return this;
    }

    public Person build() {
        return new Person(name, phone, email, address, classroom, english, motherTongue, mathematics, science, tags);
    }

}
