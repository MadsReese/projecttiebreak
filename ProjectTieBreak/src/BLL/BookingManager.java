/*
 * 
 */
package BLL;

import BE.Booking;
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
    
    private List<Booking> bookings;
    
    private BookingManager() throws IOException
    {
        accessor = BookingAccess.getInstance();
    }    
    
    public void removeBooking(Booking bookingobj) throws Exception
    {
//        accessor.delete(bookingobj);
//        bookings.delete(bookingobj);
    }
    
    public void addBooking(Booking bookingobj) throws SQLServerException, SQLException
    {
//        accessor.add(bookingobj);
    }
    
    public void update(Booking bookingobj) throws SQLServerException, SQLException
    {
//        accessor.update(bookingobj);
    }
    
    public List<Booking> getAllBookings() throws SQLServerException, SQLException
    {
        return accessor.getAllBookings();
    }
    
    public List<Court> getAllCourts() throws SQLServerException, SQLException
    {
        return accessor.getAllCourts();
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
