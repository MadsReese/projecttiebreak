/*
 * 
 */
package BLL;

import BE.Court;
import BE.Member;
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
    
    private BookingManager() throws IOException
    {
        accessor = BookingAccess.getInstance();
    }
    
    public void delete() {
        
    }
    
    public void add() {
        
    }
    
    public void update(){
        
    }
    
    public List<Court> getAll() throws SQLServerException, SQLException
    {
        return courts;
    }
            
    public static BookingManager getInstance() throws IOException
    {
        if(instance == null)
        {
            instance=new BookingManager();
        }
        return instance;
    }    
    
}
