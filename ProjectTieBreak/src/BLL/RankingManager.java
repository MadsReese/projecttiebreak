package BLL;

import BE.Match;
import BE.Member;
import DAL.RankingAccess;
import DAL.XmlReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author boinq
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
    
    public List<Member> updateRankXML(List<Member> beforeMemb, String filePath) throws Exception
    {
        XmlReader xml = new XmlReader(filePath);
        return xml.getUpdatedPoints(beforeMemb);
    }
}
