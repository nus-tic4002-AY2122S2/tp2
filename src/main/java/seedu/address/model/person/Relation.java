package seedu.address.model.person;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;


public class Relation {
    public static final String MESSAGE_CONSTRAINTS = "Should provide valid index numbers";
    private static final Logger logger = LogsCenter.getLogger(Relation.class);
    public final String value = "";

    private Set<Name> relations = new HashSet<>();

    public Relation() {
    }
    public void add(Name name) {
        relations.add(name);
    }
    public boolean isEmpty() {
        return relations.isEmpty();
    }
    public Set<Name> getSet() {
        return relations;
    }
    @Override
    public int hashCode() {
        return relations.hashCode();
    }
}
