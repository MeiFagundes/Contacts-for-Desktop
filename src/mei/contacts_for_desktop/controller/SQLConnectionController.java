package mei.contacts_for_desktop.controller;

import java.sql.Connection;
import java.sql.SQLException;
import mei.contacts_for_desktop.util.SQLConnector;
import mei.contacts_for_desktop.model.Interface.ISQLFactory;

public class SQLConnectionController {
    
    private static SQLConnectionController onlyInstance;
    private static ISQLFactory connectionFactory;
    
    private SQLConnectionController(){
        connectionFactory = new SQLConnector();
    }
    
    public static SQLConnectionController getInstance(){
        if(onlyInstance == null){
            onlyInstance = new SQLConnectionController();
        }
        return onlyInstance;
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return connectionFactory.getConnection();
    }
    
}
