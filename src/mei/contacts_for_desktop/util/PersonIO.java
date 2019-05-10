/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mei.contacts_for_desktop.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import mei.contacts_for_desktop.MainApp;
import mei.contacts_for_desktop.model.Person;
import mei.contacts_for_desktop.model.PersonListWrapper;

/**
 *
 * @author Mei
 */
public class PersonIO implements IPersonIO {
    
    private Stage primaryStage;
    private ObservableList<Person> personData;
    
    public PersonIO(Stage primaryStage, ObservableList<Person> personData){
        
        if (personData == null) {
                System.out.println("CCCCCCCCCCCCC");
            }
        
        this.primaryStage = primaryStage;
        this.personData = personData;
    }
    
    @Override
    public void Open(MainApp mainApp) throws JAXBException {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(primaryStage);

        if (file != null) {
            try {
                loadPersonDataFromFile(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PersonIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void Save(MainApp mainApp) throws JAXBException {
        
        File personFile = getPersonFilePath();
        if (personFile != null) {
            savePersonDataToFile(personFile);
        } else {
            SaveAs(mainApp);
        }
    }
    
    @Override
    public void SaveAs(MainApp mainApp) throws JAXBException {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(primaryStage);

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            savePersonDataToFile(file);
        }
    }
    
    /**
     * Returns the person file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     * 
     * @return
     */
    @Override
    public File getPersonFilePath() {
        
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }
    
    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     * 
     * @param file the file or null to remove the path
     */
    @Override
    public void setPersonFilePath(File file) {
        
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("Contacts for Desktop - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("Contacts for Desktop");
        }
    }
    
    /**
     * Loads person data from the specified file. The current person data will
     * be replaced.
     * 
     * @param file
     */
    @Override
    public void loadPersonDataFromFile(File file) throws JAXBException, FileNotFoundException {
            JAXBContext context = JAXBContext
                    .newInstance(PersonListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            try {
                
            PersonListWrapper wrapper = (PersonListWrapper) um.unmarshal(file);
            personData.clear();
            personData.addAll(wrapper.getPersons());

            // Save the file path to the registry.
            setPersonFilePath(file);
        } catch (Exception e) {}
    }
    
    /**
     * Saves the current person data to the specified file.
     * 
     * @param file
     * @throws javax.xml.bind.JAXBException
     */
    @Override
    public void savePersonDataToFile(File file) throws JAXBException {
        
            JAXBContext context = JAXBContext
                    .newInstance(PersonListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            PersonListWrapper wrapper = new PersonListWrapper();
            wrapper.setPersons(personData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setPersonFilePath(file);
    }
    
}
