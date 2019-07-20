package mei.contacts_for_desktop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.xml.bind.JAXBException;

import mei.contacts_for_desktop.model.Person;
import mei.contacts_for_desktop.util.AlertWrapper;
import mei.contacts_for_desktop.util.PersonIO;
import mei.contacts_for_desktop.util.IPersonIO;

/**
 * @author Marco Jakob, Mei
 */
public class MainApp extends Application {

    private MainUI ui;
    private IPersonIO io;
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    /**
     * The data as an observable list of Persons.
     */
    private final ObservableList<Person> personData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        
        // Add some sample data
        personData.add(new Person("Harry", "Mason"));
        personData.add(new Person("Cheryl", "Mason"));
        personData.add(new Person("Jodie", "Mason"));
        personData.add(new Person("Dahlia", "Gillespie"));
        personData.add(new Person("Alessa", "Gillespie"));
        personData.add(new Person("Cybil", "Bennett"));
        personData.add(new Person("Dr. Michael", "Kaufmann"));
        personData.add(new Person("Lisa", "Garland"));
        personData.add(new Person("James", "Sunderland"));
        personData.add(new Person("Maria", ""));
        personData.add(new Person("Angela", "Orosco"));
        personData.add(new Person("Mary", "Shepherd-Sunderland"));
        personData.add(new Person("Eddie", "Dombrowski"));
        personData.add(new Person("Laura", ""));
        
        
    }

    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Contacts for Desktop");
        
        
        io = new PersonIO(primaryStage, personData);
        
        // Set the application icon.
        this.primaryStage.getIcons().add(new Image("file:resources/images/address_book_32.png"));

        initRootLayout();

        showPersonOverview();
    }

    /**
     * Initializes the root layout and tries to load the last opened
     * person file.
     */
    public void initRootLayout() {
        
        try {
            
            try {
                
                ui = new MainUI();
                ui.initialize(this, rootLayout, primaryStage, personData);
            } catch (JAXBException ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            
            ui.showPersonOverview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     */
    public boolean showPersonEditDialog(Person person) {
        
        try {
            ui.showPersonEditDialog(person);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /**
     * Opens a dialog to show birthday statistics.
     */
    public void showBirthdayStatistics() {
        
        try {
            ui.showBirthdayStatistics(personData);
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Returns the person file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     * 
     * @return
     */
    public File getPersonFilePath() {
        
        return io.getPersonFilePath();
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     * 
     * @param file the file or null to remove the path
     */
    public void setPersonFilePath(File file) {
        
        io.setPersonFilePath(file);
    }
    
    /**
     * Loads person data from the specified file. The current person data will
     * be replaced.
     * 
     * @param file
     */
    public void loadPersonDataFromFile(File file) {
        try {
            
            io.loadPersonDataFromFile(file);

        } catch (JAXBException | FileNotFoundException e) {
                
                AlertWrapper.showError(
                        "Error",
                        "Last used data was deleted",
                        "Could not load data from file:\n" + file.getPath());
        }
    }

    /**
     * Saves the current person data to the specified file.
     * 
     * @param file
     */
    public void savePersonDataToFile(File file) {
        try {
            
            io.savePersonDataToFile(file);
            
        } catch (JAXBException e) {
                
                AlertWrapper.showError(
                        "Error",
                        "Could not save data",
                        "Could not save data to file:\n" + file.getPath());
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public MainUI getUi(){
        return ui;
    }

    public static void main(String[] args) {
        launch(args);
    }
}