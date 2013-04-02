package DAL;

import BE.Member;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
     * Constructs an instance of the MemberAccess class
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
     * Returns an instance of the MemberAccess class, and creates one first, if
     * there's none available
     *
     * @return an instance of the MemberAccess class
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
    
    // Methods \\
    
    public Member get(int id) throws SQLServerException, SQLException
    {
        try (Connection con = connector.getConnection())
        {
            String sql = "SELECT * FROM Member WHERE Id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return getOneMember(rs);
            }
            return null;
        }
    }
    
    public Member getByDTU(int DTUNo) throws SQLServerException, SQLException
    {
        try (Connection con = connector.getConnection())
        {
            String sql = "SELECT * FROM Member WHERE DTUNo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, DTUNo);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return getOneMember(rs);
            }
            return null;
        }
    }
    
    public void update(Member m) throws SQLServerException, SQLException
    {
        try (Connection con = connector.getConnection())
        {
            String sql = "UPDATE Member SET firstName = ?, lastName = ?, address = ?, phoneNo = ?, email = ? WHERE Id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, m.getFirstName());
            ps.setString(2, m.getLastName());
            ps.setString(3, m.getAddress());
            ps.setInt(4, m.getPhoneNo());
            ps.setString(5, m.getEmail());
            ps.setInt(6, m.getMemberNo());
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows < 1)
            {
                throw new SQLException("Unable to update member");
            }
        }
    }
    
    public void delete(int id) throws SQLServerException, SQLException
    {
        try (Connection con = connector.getConnection())
        {
            String sql = "DELETE FROM Member WHERE Id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows < 1)
            {
                throw new SQLException("Unable to delete member");
            }
        }
    }
    private Member getOneMember(ResultSet rs) throws SQLException
    {
        int memberNo = rs.getInt(1);
        String lastName = rs.getString(2);
        String firstName = rs.getString(3);
        String address = rs.getString(4);
        int birthYear = rs.getInt(5);
        int phoneNo = rs.getInt(6);
        String email = rs.getString(7);
        String memberType = rs.getString(8);
        int DTULicence = rs.getInt(9);
        
        return Member.fromDataBase(memberNo, 
                lastName, 
                firstName, 
                address, 
                birthYear, 
                phoneNo, 
                email, 
                memberType, 
                DTULicence);
    }
}