package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.collections.ObservableList;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.storage.StorageManager;

public class ExportCommand extends Command {

    public static final String COMMAND_WORD = "export";
    public static final String MESSAGE_SUCCESS = "Data exported successfully.";
    public static final String MESSAGE_EMPTY = "No person recorded in the system.";

    private final Path rootPath = Paths.get("").toAbsolutePath();
    private final Path txtStoragePath = Paths.get(rootPath + "/data");

    private ObservableList<Person> pLst;

    public ExportCommand() {}

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        this.pLst = model.getAddressBook().getPersonList();

        String inforToTxt = "";

        for (int i = 0; i < pLst.size(); i++) {
            String userInfo = "Name: " + pLst.get(i).getName() + "\n"
                             + "Phone: " + pLst.get(i).getPhone() + "\n"
                             + "Email: " + pLst.get(i).getEmail() + "\n"
                             + "Address: " + pLst.get(i).getAddress() + "\n"
                             + "Remark: " + pLst.get(i).getRemark() + "\n"
                             + "Tag(s): " + pLst.get(i).getTags().toString()
                             + "\n\n";

            inforToTxt += userInfo;
        }

        if (inforToTxt.equals("")) {

            return new CommandResult(MESSAGE_EMPTY);
        }

        StorageManager.exportAddressBookToTxt(inforToTxt, txtStoragePath);

        return new CommandResult(MESSAGE_SUCCESS);
    }
}
