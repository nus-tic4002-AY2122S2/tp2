package seedu.address.storage;

import seedu.address.commons.core.LogsCenter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class PersonDetailsExportationManager {

    private Path filePath;
    private String personDetails;
    private String fileName = "/personDetails.txt";

    private static final Logger logger = LogsCenter.getLogger(PersonDetailsExportationManager.class);

    public PersonDetailsExportationManager(Path filePath, String personDetails) {
        this.filePath = filePath;
        this.personDetails = personDetails;
    }

    private boolean fileDoExist() {
        return Files.exists(Paths.get(String.valueOf(filePath) + fileName));
    }

    public void exportToTxtFile() {
        if (!fileDoExist()) {
            try{
                File newFile = new File("data/personDetails.txt");
                newFile.createNewFile();
                logger.info("------------File created!---------------");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        toSaveTaskListToLocal(personDetails);
    }

    private void toSaveTaskListToLocal(String personD) {

        if(personD.equals("")) return;

        try {
            //To clear content of existing txt file
            FileWriter fw = null;
            FileWriter newFw = null;
            fw = new FileWriter(String.valueOf(filePath) + fileName);
            fw.write("");
            fw.close();

            //Start writing Task(s) in Vector<String> list into the new txt file
            newFw = new FileWriter(String.valueOf(filePath) + fileName, true);
            newFw.write(personD);
            newFw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
