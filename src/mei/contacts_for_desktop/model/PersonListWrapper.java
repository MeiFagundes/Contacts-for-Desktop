package mei.contacts_for_desktop.model;

import mei.contacts_for_desktop.model.Interface.IPersonListWrapper;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of persons. This is used for saving the
 * list of persons to XML.
 * 
 * @author Marco Jakob, Mei
 */
@XmlRootElement(name = "persons")
public class PersonListWrapper implements IPersonListWrapper {

    private List<Person> persons;

    @XmlElement(name = "person")
    @Override
    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}