package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final String address;
    private final String classroom;
    private final int english;
    private final int motherTongue;
    private final int mathematics;
    private final int science;
    private final String receiveType;
    private final List<JsonAdaptedTag> tagged = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
                             @JsonProperty("email") String email, @JsonProperty("address") String address,
                             @JsonProperty("classroom") String classroom, @JsonProperty("english") int english,
                             @JsonProperty("motherTongue") int motherTongue,
                             @JsonProperty("mathematics") int mathematics,
                             @JsonProperty("science") int science,
                             @JsonProperty("receiveType") String receiveType,
                             @JsonProperty("tagged") List<JsonAdaptedTag> tagged) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.classroom = classroom;
        this.english = english;
        this.motherTongue = motherTongue;
        this.mathematics = mathematics;
        this.science = science;
        this.receiveType = receiveType;
        if (tagged != null) {
            this.tagged.addAll(tagged);
        }
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        name = source.getName().fullName;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        address = source.getAddress().value;
        classroom = source.getClassroom().value;
        english = source.getEnglish().score;
        motherTongue = source.getMotherTongue().score;
        mathematics = source.getMathematics().score;
        science = source.getScience().score;
        receiveType = source.getReceiveType().value;
        tagged.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public <Classsroom> Person toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            personTags.add(tag.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);

        if (classroom == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Classroom.class.getSimpleName()));
        }
        if (!Classroom.isValidClassroom(classroom)) {
            throw new IllegalValueException(Classroom.MESSAGE_CONSTRAINTS);
        }
        final Classroom modelClassroom = new Classroom(classroom);

        if (Integer.toString(english) == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    English.class.getSimpleName()));
        }
        if (!English.isValidScore(english)) {
            throw new IllegalValueException(English.MESSAGE_CONSTRAINTS);
        }
        final English modelEnglish = new English(english);

        if (Integer.toString(motherTongue) == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    MotherTongue.class.getSimpleName()));
        }
        if (!MotherTongue.isValidScore(motherTongue)) {
            throw new IllegalValueException(MotherTongue.MESSAGE_CONSTRAINTS);
        }
        final MotherTongue modelMotherTongue = new MotherTongue(motherTongue);

        if (Integer.toString(mathematics) == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Mathematics.class.getSimpleName()));
        }
        if (!Mathematics.isValidScore(mathematics)) {
            throw new IllegalValueException(Mathematics.MESSAGE_CONSTRAINTS);
        }
        final Mathematics modelMathematics = new Mathematics(mathematics);

        if (Integer.toString(science) == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Science.class.getSimpleName()));
        }
        if (!Science.isValidScore(science)) {
            throw new IllegalValueException(Science.MESSAGE_CONSTRAINTS);
        }
        final Science modelScience = new Science(science);

        if (receiveType == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!ReceiveType.isValidReceiveType(receiveType)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final ReceiveType modelReceiveType = new ReceiveType(receiveType);

        final Set<Tag> modelTags = new HashSet<>(personTags);
        return new Person(modelName, modelPhone, modelEmail, modelAddress, modelClassroom, modelEnglish,
                modelMotherTongue, modelMathematics, modelScience, modelReceiveType, modelTags);
    }

}
