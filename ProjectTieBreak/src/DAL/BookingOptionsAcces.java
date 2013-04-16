/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Jesper
 */
public class BookingOptionsAcces
{
    private Connector connector;
    private static BookingOptionsAcces instance;
    
    
    private BookingOptionsAcces() throws FileNotFoundException, IOException
    {
        connector = Connector.getInstance();
    }
    
    /**
     * 
     * @return
     * @throws IOException 
     */
    public static BookingOptionsAcces getInstance() throws IOException
    {
        if(instance == null)
        {
            instance = new BookingOptionsAcces();
        }
        return instance;
    }
    
    public void setOutdoorCourtDates(String from,String to)
    {
        
    }
    
    public void setOutdoorCourtTimes(int from, int to)
    {
        
    }
}
