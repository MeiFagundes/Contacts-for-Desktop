/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mei.contacts_for_desktop.view;

import java.util.List;
import mei.contacts_for_desktop.model.IPerson;
import mei.contacts_for_desktop.model.Person;

/**
 *
 * @author Mei
 */
public interface IBirthdayStatisticsController {

    /**
     * Sets the persons to show the statistics for.
     *
     * @param persons
     */
    void setPersonData(List<Person> persons);
    
}
