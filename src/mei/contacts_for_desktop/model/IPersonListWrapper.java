/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mei.contacts_for_desktop.model;

import java.util.List;

/**
 *
 * @author Mei
 */
public interface IPersonListWrapper {
    
    public List<Person> getPersons();
    public void setPersons(List<Person> persons);
}
