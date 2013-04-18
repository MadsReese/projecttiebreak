/*
 * 
 */
package DAL;

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
 * @author boinq
 */
public class RankingAccess {
    /* Management */
    // Instance variables \\
    private Connector connector;
    private static RankingAccess instance = null;
    
    // Constructor \\
    /**
     * Constructs an instance of the MemberAccess class
     *
     * @throws FileNotFoundException if the config file is not found
     * @throws IOException if there's an error reading the config file
     */
    private RankingAccess()throws FileNotFoundException, IOException
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
    public static RankingAccess getInstance() throws FileNotFoundException, IOException
    {
        if (instance == null)
        {
            instance = new RankingAccess();
        }
        return instance;
     }

    public List<Member> getByRank() throws SQLServerException, SQLException
    {
        
        try(Connection con = connector.getConnection())
        {
        String sql =
        "Select *"
        + " From Member"
        + " Where Member.DTU_Points <> 0"
        + " order by DTU_Points DESC";
        
        PreparedStatement ps = con.prepareStatement(sql);
                        
        ResultSet rs = ps.executeQuery();
        
        List<Member> ranked = new ArrayList();
        
        while(rs.next())
        {
            ranked.add(getOneMember(rs));
        }        
        return ranked;
        }
    }
    
    
    
    
    private Member getOneMember(ResultSet rs) throws SQLException
    {
        int memberNo = rs.getInt(1);
        String firstName = rs.getString(2);
        String lastName = rs.getString(3);
        String address = rs.getString(4);
        int birthYear = rs.getInt(5);
        int phoneNo = rs.getInt(6);
        String email = rs.getString(7);
        String memberType = rs.getString(9);
        int DTUPoints = rs.getInt(10);
        int DTULicence = rs.getInt(11);
        
        return Member.fromDataBase(memberNo, lastName, firstName, address, birthYear, phoneNo, email, memberType, DTULicence, DTUPoints);
    }
}
