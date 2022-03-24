package seedu.address.model.person;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class RelateToPersonPredicate implements Predicate<Person> {
    private final Person person;

    public RelateToPersonPredicate(Person person) {
        this.person = person;
    }

    @Override
    public boolean test(Person person) {
        Set<Name> set = new HashSet<>();
        set.add(this.person.getName());
        set.addAll(this.person.getRelation().getSet());
        return set.stream()
                .anyMatch(n -> n.equals(person.getName()));
    }
}
