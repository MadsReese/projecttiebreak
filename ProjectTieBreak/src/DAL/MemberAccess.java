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
            String sql = "SELECT * FROM Team WHERE Id = ?";
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
        
        
    }
}