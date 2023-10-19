package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.ListLeadCommand.MESSAGE_SUCCESS;
import static seedu.address.testutil.TypicalClients.getTypicalClientsAddressBook;
import static seedu.address.testutil.TypicalLeads.getTypicalLeadsAddressBook;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;

public class ListLeadCommandTest {

    private Model personModel;
    private Model expectedPersonModel;
    private Model leadModel;
    private Model expectedLeadModel;
    private Model clientModel;
    private Model expectedClientModel;
    @BeforeEach
    public void setUp() {
        personModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedPersonModel = new ModelManager(personModel.getAddressBook(), new UserPrefs());
        leadModel = new ModelManager(getTypicalLeadsAddressBook(), new UserPrefs());
        expectedLeadModel = new ModelManager(leadModel.getAddressBook(), new UserPrefs());
        clientModel = new ModelManager(getTypicalClientsAddressBook(), new UserPrefs());
        expectedClientModel = new ModelManager(clientModel.getAddressBook(), new UserPrefs());
    }


    @Test
    public void execute_personListIsFiltered_showsEverything() {
        // Filter the model as required by ListLeadCommand
        Predicate<Person> predicate = ListLeadCommand.LEAD_TAG_PREDICATE;
        personModel.updateFilteredPersonList(predicate);
        expectedPersonModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(new ListLeadCommand(), personModel, MESSAGE_SUCCESS, expectedPersonModel);
    }

    //filter list with only leads
    @Test
    public void execute_leadListIsFiltered_showsEverything() {
        // Filter the model as required by ListLeadCommand
        Predicate<Person> predicate = ListLeadCommand.LEAD_TAG_PREDICATE;
        leadModel.updateFilteredPersonList(predicate);
        expectedLeadModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(new ListLeadCommand(), leadModel, ListLeadCommand.MESSAGE_SUCCESS, expectedLeadModel);
    }

    //filter list with only clients
    @Test
    public void execute_clientListIsFiltered_showsEverything() {
        // Filter the model as required by ListLeadCommand
        Predicate<Person> predicate = ListLeadCommand.LEAD_TAG_PREDICATE;
        clientModel.updateFilteredPersonList(predicate);
        expectedClientModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(new ListLeadCommand(), clientModel, MESSAGE_SUCCESS, expectedClientModel);
    }
}

