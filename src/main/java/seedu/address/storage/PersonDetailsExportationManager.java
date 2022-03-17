package seedu.address.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;

public class PersonDetailsExportationManager {

    private static final Logger logger = LogsCenter.getLogger(PersonDetailsExportationManager.class);

    private Path filePath;
    private String personDetails;
    private String fileName = "/personDetails.txt";

    /**
     * Constructor
     * @param filePath is the local storage file path
     * @param personDetails is all the person details in String type
     */
    public PersonDetailsExportationManager(Path filePath, String personDetails) {
        this.filePath = filePath;
        this.personDetails = personDetails;
    }

    /**
     * To check whether the personDetails.txt exist in the target filePath
     * @return true if the txt file exist or false if the txt file not exist
     */
    private boolean fileDoExist() {
        return Files.exists(Paths.get(String.valueOf(filePath) + fileName));
    }

    /**
     * To start export all the perons' details information to local storage
     */
    public void exportToTxtFile() {
        if (!fileDoExist()) {
            try {
                File newFile = new File("data/personDetails.txt");
                newFile.createNewFile();
                logger.info("------------File created!---------------");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        toSavePersonDetailsToLocal(personDetails);
    }

    /**
     * The function to achieve saving person details to local storage
     * @param personD entire person details
     */
    private void toSavePersonDetailsToLocal(String personD) {

        if (personD.equals("")) {

            return;
        }

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
