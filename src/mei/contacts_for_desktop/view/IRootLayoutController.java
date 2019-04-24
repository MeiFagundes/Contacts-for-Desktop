/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mei.contacts_for_desktop.view;

import mei.contacts_for_desktop.MainApp;

/**
 *
 * @author Mei
 */
public interface IRootLayoutController {

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    void setMainApp(MainApp mainApp);
    
}
