/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.BookingOptions;
import BE.Member;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesper
 */
public class BookingOptionsAccess
{
    private Connector connector;
    private static BookingOptionsAccess instance;
    
    
    private BookingOptionsAccess() throws FileNotFoundException, IOException
    {
        connector = Connector.getInstance();
    }
    
    /**
     * 
     * @return
     * @throws IOException 
     */
    public static BookingOptionsAccess getInstance() throws IOException
    {
        if(instance == null)
        {
            instance = new BookingOptionsAccess();
        }
        return instance;
    }
    
    public void updateAll(BookingOptions...options) throws SQLException
    {
        try (Connection con = connector.getConnection())
        {
            for(BookingOptions b: options)
            {
            String sql =
            "Insert into CourtType (RentableFromDate,RentableToDate,price,RentableFromTime,RentableToTime)"
            + " Values (?,?,?,?,?)"
            + " Where Type = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, b.getRentableFromDate());
            ps.setString(2, b.getRentableToDate());
            ps.setDouble(3, b.getPrice());
            
            }
        }
    }        
    
            
    public ArrayList<BookingOptions> getAll() throws SQLException
    {
        try (Connection con = connector.getConnection())
        {
            String sql =
            "select *"
            + " from CourtType";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            ArrayList<BookingOptions> courtTypes = new ArrayList();
            
            while(rs.next())
            {
                courtTypes.add(getOneBookingOptions(rs));
            }
            
            return courtTypes;
        }
        
    }
    
    private BookingOptions getOneBookingOptions(ResultSet rs) throws SQLException
    {
        String type = rs.getString("type");
        String fromDate = rs.getString("RentableFromDate");
        String toDate = rs.getString("RentableToDate");
        double price = rs.getDouble("Price");
        int rentableFromTime = rs.getInt("RentableFromTime");
        int rentableToTime = rs.getInt("RentableToTime");
        
        return new BookingOptions(type,fromDate,toDate,price,rentableFromTime,rentableToTime);
    }
}
