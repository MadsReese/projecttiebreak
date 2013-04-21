/*
 * 
 */
package BLL;

import BE.Member;
import DAL.BookingAccess;
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
    
    
    private BookingManager() throws IOException
    {
        accessor = BookingAccess.getInstance();
    }
    
    public static BookingManager getInstance() throws IOException
    {
        if(instance == null)
        {
            instance=new BookingManager();
        }
        return instance;
    }
    
    public List<Member> getByRank() throws SQLException 
    {
        return accessor.getByRank();
    }
}
