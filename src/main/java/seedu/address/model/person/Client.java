package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.addItemToSet;

import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Client in the address book.
 */
public class Client extends Person {
    public static final String TAG_CLIENT = "Client";

    /**
     * Every field must be present and not null.
     */
    public Client(Name name, Phone phone, Email email, Address address, Set<Tag> tags) {
        super(name, phone, email, address, addItemToSet(tags, new Tag(TAG_CLIENT)));
    }

    @Override
    public boolean isClient() {
        return true;
    }

    @Override
    public boolean isLead() {
        return false;
    }
}