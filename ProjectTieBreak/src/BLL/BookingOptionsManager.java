/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BookingOptionsAccess;
import java.io.IOException;

/**
 *
 * @author Jesper
 */
public class BookingOptionsManager
{
    private static BookingOptionsManager instance;
    private static BookingOptionsAccess accessor;
    
    private BookingOptionsManager() throws IOException
    {
        accessor = BookingOptionsAccess.getInstance();
    }
    
    public static BookingOptionsManager getInstance() throws IOException
    {
        if(instance==null)
        {
            instance=new BookingOptionsManager();
        }
        return instance;        
    }
    
  
    
    public void setOutdoorPrice(double price)
    {
        
    }
}
