/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author Reese
 */
public class Connector
{

    /* Management */
    // Instance variables \\
    private Properties config;
    private static SQLServerDataSource dataSource;
    private static Connector instance = null;

    // Constructor \\
    /**
     * Constructs an instance of the Connector class
     *
     * @throws FileNotFoundException if the config file cannot be found
     * @throws IOException if there's an error reading the config file
     */
    private Connector() throws FileNotFoundException, IOException
    {
        config = new Properties();
        config.load(new FileReader(System.getProperty("user.dir") + "/config.cfg"));
        dataSource = new SQLServerDataSource();
        dataSource.setServerName(config.getProperty("SERVER"));
        dataSource.setPortNumber(Integer.valueOf(config.getProperty("PORT")));
        dataSource.setDatabaseName(config.getProperty("DATABASE"));
        dataSource.setUser(config.getProperty("USER"));
        dataSource.setPassword(config.getProperty("PASS"));
    }

    // Singleton \\
    /**
     * Returns an instance of the Connector, or creates one first, if none is
     * available.
     *
     * @return an instance of the Connector
     * @throws FileNotFoundException if the config file cannot be found
     * @throws IOException if there's an error reading the config file
     */
    protected static Connector getInstance() throws FileNotFoundException, IOException
    {
        if (instance == null)
        {
            instance = new Connector();
        }
        return instance;
    }

    /* Methods */
    // Getter \\
    /**
     * Creates and returns a connection to the database
     *
     * @return a connection to the database
     * @throws SQLServerException if there's an error connecting to the database
     */
    protected Connection getConnection() throws SQLServerException
    {
        return dataSource.getConnection();
    }
}