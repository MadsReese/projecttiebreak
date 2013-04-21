/**
 * Project Tie-Break, EASV (2nd Semester, 2013)
 *
 * @author Kasper Pedersen, Jesper Agerbo Hansen,
 * @author Mads Funch Patrzalek Reese and Jakob Hansen.
 *
 * Code stored at: https://github.com/MadsReese/projecttiebreak
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
 * RankingAccess
 * @author Mads Funch Patrzalek Reese, Kasper Pedersen, Jakob Hansen
 */
public class RankingAccess {
    /* Management */
    // Instance variables \\
    private Connector connector;
    private static RankingAccess instance = null;
    
    // Constructor \\
    /**
     * Constructs an instance of the MemberAccess class
     * @author Mads Funch Patrzalek Reese
     * @throws FileNotFoundException if the configuration file is not found
     * @throws IOException if there's an error reading the configuration file
     */
    private RankingAccess()throws FileNotFoundException, IOException
    {
        connector = Connector.getInstance();
    }

    // Singleton \\
    /**
     * Returns an instance of the RankingAccess class, and creates one first, if
     * there's none available
     * @author Mads Funch Patrzalek Reese
     * @return an instance of the MemberAccess class
     * @throws FileNotFoundException if the configuration file can't be found
     * @throws IOException if there's an error reading the configuration file
     */
    public static RankingAccess getInstance() throws FileNotFoundException, IOException
    {
        if (instance == null)
        {
            instance = new RankingAccess();
        }
        return instance;
     }

    /**
     * Get members by rank from the database.
     * @author Kasper Pedersen
     * @return a list of members sorted in descending order by their points.
     * @throws SQLServerException --
     * @throws SQLException --
     */
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
    
    /**
     * Get a specified age-group by comparing birth-year with the current year.
     * @author Jakob Hansen
     * @param age the age, results should be below.
     * @return an arrayList containing all members in the given age-group.
     * @throws SQLServerException --
     * @throws SQLException  --
     */
    public List<Member> getBelowAge(int age) throws SQLServerException, SQLException
    {
        try (Connection con = connector.getConnection())
        {
            String sql =
              "SELECT *"
            + "FROM Member"
            + "WHERE (year(getdate()) - Member.Birth_Year) < ?"
            + "ORDER BY DTU_Points DESC";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,"" + age);
            ResultSet rs = ps.executeQuery();
            
            List<Member> agegroup = new ArrayList();
            while(rs.next())
            {
                agegroup.add(getOneMember(rs));
            }
            return agegroup;
        }
    }

    /**
     * Gets one member from the resultSet from the database.
     * @author Kasper Pedersen
     * @param rs the resultSet to be fetched from.
     * @return one Member object from the resultSet.
     * @throws SQLException --
     */
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