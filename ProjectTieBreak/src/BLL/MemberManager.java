/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Member;
import DAL.MemberAccess;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reese
 */
public class MemberManager
{
    private static MemberManager instance = null;
    private MemberAccess accessor;
    private List<Member> members = null;
    
    private MemberManager() throws FileNotFoundException, IOException, SQLServerException, SQLException
    {
        accessor = MemberAccess.getInstance();
        members = accessor.getAll();
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
    public static MemberManager getInstance() throws FileNotFoundException, IOException, SQLServerException, SQLException
    {
        if (instance == null)
        {
            instance = new MemberManager();
        }
        return instance;
    }
    
    public ArrayList<Member> getByName(String name) 
    {
        String searchString;
        ArrayList<Member> result = new ArrayList<>();
        for(Member m : members)
        {
            searchString = m.getFirstName() + " " + m.getLastName();
            if(name.contains(searchString))
                result.add(m);
        }
        return result;
    }
    
    public Member getByMemberNo(String id)
    {
        for(Member m : members)
        {
            String mNo = "" + m.getMemberNo();
            if(mNo.equals(id))
                return m;
        }
        return null;
    }
}
