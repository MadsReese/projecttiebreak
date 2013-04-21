/*
 * 
 */
package BLL;

import BE.BookingOptions;
import BE.Court;
import DAL.BookingAccess;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author boinq
 */
public class BookingManager {
    private static BookingManager instance;
    private static BookingAccess accessor;
    private List<Court> courts;
    private List<Court> bookings;
    
    private BookingManager() throws IOException
    {
        accessor = BookingAccess.getInstance();
    }
    
    public void deleteCourt() {
        
    }
    
    public void removeBooking() {
        //accessor.delete(bo.);
        //bookings.delete(bo);
    }
    
    public void addBooking(String t, String f, String m) {
        t = 
        f = 
        m = 
    }
    
    public void update(){
        
    }
    
    public List<Court> getAllBookings() throws SQLServerException, SQLException
    {
        return bookings;
    }
    
    public List<Court> getAllCourts() throws SQLServerException, SQLException
    {
        return courts;
    }
            
    public static BookingManager getInstance() throws IOException
    {
        if(instance == null)
        {
            instance = new BookingManager();
        }
        return instance;
    }    
    
}
