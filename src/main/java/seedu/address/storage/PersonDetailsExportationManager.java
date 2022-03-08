package seedu.address.storage;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PersonDetailsExportationManager {

    private Path filePath;
    private String personDetails;

    public PersonDetailsExportationManager(Path filePath, String personDetails) {
        this.filePath = filePath;
        this.personDetails = personDetails;
    }

    private boolean fileDoExist() {
        return Files.exists(filePath);
    }

    public void exportToTxtFile() throws IOException {
        if (!fileDoExist()) {
            Files.createFile(filePath);
        }

        toSaveTaskListToLocal(personDetails);
    }

    private void toSaveTaskListToLocal(String personD) throws IOException {

        if(personD.equals("")) return;

        //To clear content of existing txt file
        FileWriter fw = new FileWriter(String.valueOf(filePath));
        fw.write("");
        fw.close();
    }

}
