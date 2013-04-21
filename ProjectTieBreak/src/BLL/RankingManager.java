/**
 * Project Tie-Break, EASV (2nd Semester, 2013)
 *
 * @author Kasper Pedersen, Jesper Agerbo Hansen,
 * @author Mads Funch Patrzalek Reese and Jakob Hansen.
 *
 * Code stored at: https://github.com/MadsReese/projecttiebreak
 */
package BLL;

import BE.Match;
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
    
    private static RankingManager instance;
    private static RankingAccess accessor;
    
    
    private RankingManager() throws IOException
    {
        accessor = RankingAccess.getInstance();
    }
    
    public static RankingManager getInstance() throws IOException
    {
        if(instance == null)
        {
            instance=new RankingManager();
        }
        return instance;
    }
    
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
    public List<Member> getByAge(int agelimit) throws SQLException
    {
        Calendar c = Calendar.getInstance();
        List<Member> members = accessor.getBelowAge(agelimit);
        List<Member> results = new ArrayList();
        for (Member m : members)
        {
            int age = c.get(Calendar.YEAR)-m.getBirthYear();
            switch(agelimit)
            {
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