package seedu.address.model.person;

import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Teacher in the address book.
 * Inherits from the Person class and includes an additional gender field.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Teacher extends Person {

    private final Gender gender;
    private final Subject subject;
    private final Set<String> classes;

    /**
     * Constructs a {@code Teacher} with the specified details.
     *
     * @param name The name of the teacher. Must not be null.
     * @param gender The gender of the teacher. Must not be null.
     * @param phone The phone number of the teacher. Must not be null.
     * @param email The email address of the teacher. Must not be null.
     * @param address The address of the teacher. Must not be null.
     * @param tags The set of tags associated with the teacher. Must not be null.
     * @param subject The subject taught by the teacher. Must not be null.
     * @param classes The set of classes taught by the teacher. Must not be null.
     * @throws NullPointerException if any of the parameters are null.
     */
    public Teacher(Name name, Gender gender, Phone phone, Email email, Address address, Set<Tag> tags,
                   Subject subject, Set<String> classes) {
        super(name, phone, email, address, tags);
        Objects.requireNonNull(gender, "Gender cannot be null");
        this.gender = gender;
        Objects.requireNonNull(subject, "Subject cannot be null");
        this.subject = subject;
        Objects.requireNonNull(classes, "Classes cannot be null");
        this.classes = classes;
    }

    public Gender getGender() {
        return this.gender;
    }

    public Subject getSubject() {
        return this.subject;
    }

    public Set<String> getClasses() {
        return this.classes;
    }

    /**
     * Returns true if both teachers have the same name.
     * This defines a weaker notion of equality between two teachers.
     */
    public boolean isSameTeacher(Teacher otherTeacher) {
        if (otherTeacher == this) {
            return true;
        }

        return otherTeacher != null
            && otherTeacher.getName().equals(getName());
    }

    /**
     * Returns true if both Teachers have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Teacher)) {
            return false;
        }

        Teacher otherTeacher = (Teacher) other;
        return getName().equals(otherTeacher.getName())
            && getGender().equals(otherTeacher.getGender())
            && getPhone().equals(otherTeacher.getPhone())
            && getEmail().equals(otherTeacher.getEmail())
            && getAddress().equals(otherTeacher.getAddress())
            && getTags().equals(otherTeacher.getTags())
            && getSubject().equals(otherTeacher.getSubject())
            && getClasses().equals(otherTeacher.getClasses());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("Role", "Teacher")
            .add("name", getName())
            .add("gender", gender)
            .add("phone", getPhone())
            .add("email", getEmail())
            .add("address", getAddress())
            .add("tags", getTags())
            .add("subject", subject)
            .add("classes", classes)
            .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGender(), getPhone(), getEmail(), getAddress(),
            getTags(), getSubject(), getClasses());
    }

}
