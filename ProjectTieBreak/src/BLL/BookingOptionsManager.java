/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.BookingOptions;
import DAL.BookingOptionsAccess;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
  
    
    public void updateAll(BookingOptions...options) throws SQLException
    {
        accessor.updateAll(options);
    }
    
    public ArrayList<BookingOptions> getAll() throws SQLException
    {
        return accessor.getAll();
    }
}
