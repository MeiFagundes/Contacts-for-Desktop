/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mei.contacts_for_desktop.util;

import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;
import mei.contacts_for_desktop.MainApp;

/**
 *
 * @author Mei
 */
public interface IPersonIO {

    public void Open(MainApp mainApp) throws JAXBException;

    public void Save(MainApp mainApp) throws JAXBException;

    public void SaveAs(MainApp mainApp) throws JAXBException;
    
    public File getPersonFilePath();
    
    public void setPersonFilePath(File file);
    
    public void loadPersonDataFromFile(File file) throws JAXBException, FileNotFoundException;
    
    public void savePersonDataToFile(File file) throws JAXBException;
    
    
}
