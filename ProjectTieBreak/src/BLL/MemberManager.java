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
import java.util.Calendar;
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
    
    public List<Member> getAll() throws SQLServerException, SQLException
    {
        return accessor.getAll();
    }
    
    public void addMember(String firstName, String lastName,String address, int birthYear, String email, int phoneNo) throws SQLServerException, SQLException
    {
        int memberNo=0000;
        Calendar c = Calendar.getInstance();
        int age = c.get(Calendar.YEAR)-birthYear;
        String membertype = "senior";
        //Determinants
        for(Member m : members)
        {
            if(m.getMemberNo()>memberNo)
                memberNo = m.getMemberNo()+1;
        }
        if(age < 18)
        {
            membertype = "junior";
        }
        else if(age > 60)
        {
            membertype = "retiree";
        }
        
        Member m = Member.fromDataBase(memberNo, lastName, firstName, address, birthYear, phoneNo, email, membertype, 0, 0);
        
        accessor.add(m);
        members.add(m);
    }
}
