/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mei.contacts_for_desktop.model;

import java.io.File;
import java.io.FileNotFoundException;
import javafx.collections.ObservableList;
import javax.xml.bind.JAXBException;
import mei.contacts_for_desktop.MainApp;

/**
 *
 * @author Mei
 */
public interface IModelIO {

    public File OpenFile() throws JAXBException;

    public void Save(MainApp mainApp) throws JAXBException;

    public void SaveAs(ObservableList<Person> personData) throws JAXBException;
    
    public File getFilePath();
    
    public void setFilePath(File file);
    
    public void loadDataFromFile(File file, ObservableList<Person> personData) throws JAXBException, FileNotFoundException;
    
    public void saveDataToFile(File file, ObservableList<Person> personData) throws JAXBException;
    
    
}
