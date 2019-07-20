package mei.contacts_for_desktop.model;

import java.time.LocalDate;
import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import mei.contacts_for_desktop.util.LocalDateAdapter;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob, Mei
 */
public class Person implements IPerson {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthday;
    
    private static int dummyMonth;
    private static int dummyDay;
    private static int dummyYear;
    
    static {
        randomizeDummyInfo();
    }

    /**
     * Default constructor.
     */
    public Person() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // Some initial dummy data, just for convenient testing.
        this.street = new SimpleStringProperty("Street");
        this.postalCode = new SimpleIntegerProperty(30640640);
        this.city = new SimpleStringProperty("City");
        this.birthday = new SimpleObjectProperty<>(LocalDate.of(dummyYear, dummyMonth, dummyDay));
        
        randomizeDummyInfo();
    }
    
    private static void randomizeDummyInfo(){
        
        Random r = new Random();
        dummyMonth = r.nextInt(11) + 1;
        dummyDay = r.nextInt(27) + 1;
        dummyYear = r.nextInt(29) + 1990;
    }

    @Override
    public String getFirstName() {
        return firstName.get();
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    @Override
    public StringProperty firstNameProperty() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName.get();
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    @Override
    public StringProperty lastNameProperty() {
        return lastName;
    }

    @Override
    public String getStreet() {
        return street.get();
    }

    @Override
    public void setStreet(String street) {
        this.street.set(street);
    }

    @Override
    public StringProperty streetProperty() {
        return street;
    }

    @Override
    public int getPostalCode() {
        return postalCode.get();
    }

    @Override
    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    @Override
    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    @Override
    public String getCity() {
        return city.get();
    }

    @Override
    public void setCity(String city) {
        this.city.set(city);
    }

    @Override
    public StringProperty cityProperty() {
        return city;
    }

    @Override
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthday() {
        return birthday.get();
    }

    @Override
    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    @Override
    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }
}