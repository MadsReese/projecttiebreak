/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Reese
 */
public class MemberAccess
{
    /* Management */
    // Instance variables \\
    private Connector connector;
    private static MemberAccess instance = null;

    // Constructor \\
    /**
     * Constructs an instance of the TeamAccess class
     *
     * @throws FileNotFoundException if the config file is not found
     * @throws IOException if there's an error reading the config file
     */
    private MemberAccess() throws FileNotFoundException, IOException
    {
        connector = Connector.getInstance();
    }

    // Singleton \\
    /**
     * Returns an instance of the TeamAccess class, and creates one first, if
     * there's none available
     *
     * @return an instance of the TeamAccess class
     * @throws FileNotFoundException if the config file can't be found
     * @throws IOException if there's an error reading the config file
     */
    public static MemberAccess getInstance() throws FileNotFoundException, IOException
    {
        if (instance == null)
        {
            instance = new MemberAccess();
        }
        return instance;
    }
    
    
}
