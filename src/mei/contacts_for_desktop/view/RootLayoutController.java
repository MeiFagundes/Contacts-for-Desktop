package mei.contacts_for_desktop.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.xml.bind.JAXBException;
import mei.contacts_for_desktop.MainApp;
import mei.contacts_for_desktop.util.PersonIO;
import mei.contacts_for_desktop.util.IPersonIO;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author Marco Jakob, Mei
 */
public class RootLayoutController implements IRootLayoutController {

    // Reference to the main application
    private MainApp mainApp;
    
    private IPersonIO fileIO;

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    @Override
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Creates an empty address book.
     */
    @FXML
    private void handleNew() {
        mainApp.getPersonData().clear();
        mainApp.setPersonFilePath(null);
    }

    /**
     * Opens a FileChooser to let the user select an address book to load.
     */
    @FXML
    private void handleOpen() {
        
        fileIO = new PersonIO(mainApp.getPrimaryStage(), mainApp.getPersonData());
        try {
            fileIO.Open(mainApp);
        } catch (JAXBException ex) {
            Logger.getLogger(RootLayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Saves the file to the person file that is currently open. If there is no
     * open file, the "save as" dialog is shown.
     */
    @FXML
    private void handleSave() {
        
        fileIO = new PersonIO(mainApp.getPrimaryStage(), mainApp.getPersonData());
        try {
            fileIO.Save(mainApp);
        } catch (JAXBException ex) {
            Logger.getLogger(RootLayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    @FXML
    private void handleSaveAs() {
        
        fileIO = new PersonIO(mainApp.getPrimaryStage(), mainApp.getPersonData());
        try {
            fileIO.SaveAs(mainApp);
        } catch (JAXBException ex) {
            Logger.getLogger(RootLayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("AddressApp");
    	alert.setHeaderText("About");
    	alert.setContentText("Author: Marco Jakob\nWebsite: http://code.makery.ch");

    	alert.showAndWait();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    /**
     * Opens the birthday statistics.
     */
    @FXML
    private void handleShowBirthdayStatistics() {
      mainApp.showBirthdayStatistics();
    }
}