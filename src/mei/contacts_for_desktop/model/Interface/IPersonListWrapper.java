/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mei.contacts_for_desktop.model.Interface;

import java.util.List;
import mei.contacts_for_desktop.model.Person;

/**
 *
 * @author Mei
 */
public interface IPersonListWrapper {
    
    public List<Person> getPersons();
    public void setPersons(List<Person> persons);
}
