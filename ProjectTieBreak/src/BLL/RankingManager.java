/**
 * Project Tie-Break, EASV (2nd Semester, 2013)
 *
 * @author Kasper Pedersen, Jesper Agerbo Hansen,
 * @author Mads Funch Patrzalek Reese and Jakob Hansen.
 *
 * Code stored at: https://github.com/MadsReese/projecttiebreak
 */
package BLL;

import BE.Member;
import DAL.RankingAccess;
import DAL.XmlReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * RankingManager
 * @author Mads Funch Patrzalek Reese, Kasper Pedersen, Jakob Hansen
 */
public class RankingManager 
{
    // Instance variables \\
    private static RankingManager instance;
    private static RankingAccess accessor;
        
    /**
     * Constructs an instance of the RankingManager-object.
     * @author Mads Funch Patrzalek Reese
     * @throws IOException 
     */
    private RankingManager() throws IOException
    {
        accessor = RankingAccess.getInstance();
    }
    
    /**
     * Returns an instance of the RankingManager class, and creates one first, if
     * there's none available 
     * @return an instance of the RankingManager
     * @throws IOException --
     */
    public static RankingManager getInstance() throws IOException
    {
        if(instance == null)
        {
            instance = new RankingManager();
        }
        return instance;
    }
    
    /**
     * Returns all members in a list by rank.
     * @author Mads Funch Patrzalek Reese
     * @return a list containing results.
     * @throws SQLException --
     */
    public List<Member> getByRank() throws SQLException 
    {
        return accessor.getByRank();
    }
    
    /**
     * Returns a given age-group of players
     * @author Jakob hansen
     * @param agelimit the maximum-age for the age-range.
     * @return a list containing the age-group ranked in descending order by points.
     * @throws SQLException --
     */
    public List<Member> getBelowAge(int agelimit) throws SQLException
    {
        Calendar c = Calendar.getInstance();
        List<Member> results = new ArrayList();
        List<Member> members = new ArrayList();
        if (agelimit == 0)
        {
            members = accessor.getBelowAge(Integer.MAX_VALUE);
        }
        else
        {
            members = accessor.getBelowAge(agelimit);
        }
        for (Member m : members)
        {
            int age = c.get(Calendar.YEAR)-m.getBirthYear();
            switch(agelimit)
            {
                case 0:
                    results.add(m);
                    break;
                case 10:
                    if (age < 10)
                    {
                        results.add(m);
                        break;
                    }
                    break;
                case 12:
                    if (age >= 10)
                    {
                        results.add(m);
                        break;
                    }
                    break;
                case 14:
                    if (age >= 12)
                    {
                        results.add(m);
                        break;
                    }
                    break;
                case 16:
                    if (age >= 14)
                    {
                        results.add(m);
                        break;
                    }
                    break;
                case 18:
                    if (age >= 16)
                    {
                        results.add(m);
                        break;
                    }
                    break;
                case 100:
                    if (age >= 18)
                    {
                        results.add(m);
                        break;
                    }
            }
        }
        return results;
    }
    
    /**
     * updateRankXML
     * @author Mads Funch Patrzalek Reese
     * @param beforeMemb list containing members.
     * @param filePath the path to the XML-document.
     * @return --
     * @throws Exception --
     */
    public List<Member> updateRankXML(List<Member> beforeMemb, String filePath) throws Exception
    {
        XmlReader xml = new XmlReader(filePath);
        return xml.getUpdatedPoints(beforeMemb);
    }
}