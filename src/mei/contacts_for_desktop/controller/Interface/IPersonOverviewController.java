/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mei.contacts_for_desktop.controller.Interface;

import mei.contacts_for_desktop.Main;

/**
 *
 * @author Mei
 */
public interface IPersonOverviewController {

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    void setMainApp(Main mainApp);
    
}
