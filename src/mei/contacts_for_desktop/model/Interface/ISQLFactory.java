package mei.contacts_for_desktop.model.Interface;

import java.sql.Connection;
import java.sql.SQLException;

public interface ISQLFactory {
    
    Connection getConnection() throws ClassNotFoundException, SQLException;

}
