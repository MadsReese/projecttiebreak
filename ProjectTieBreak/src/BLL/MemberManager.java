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
    private List<Member> members;
    
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
    
    public ArrayList<Member> getByName(String searchString) 
    {
        String name;
        ArrayList<Member> result = new ArrayList<>();
        for(Member m : members)
        {
            name = m.getFirstName().toLowerCase() + " " + m.getLastName().toLowerCase();
            if(name.contains(searchString))
            {
                result.add(m);
            }
        }
        return result;
    }
    
    public ArrayList<Member> getByMemberNo(String id)
    {
        String memNo;
        ArrayList<Member> result = new ArrayList<>();
        for(Member m : members)
        {
            memNo = m.getMemberNo() + "";
            if(memNo.contains(id))
                result.add(m);
        }
        return result;
    }
    
    
    public List<Member> getAll() throws SQLServerException, SQLException
    {
        return members;
    }
    
    @Deprecated
    public void debugAdd(Member m) throws Exception
    {
        accessor.add(m);
        members.add(m);
    }
    
    /**
     * Deletes a member from the database and from the local memory
     * @param m The Member to delete
     * @throws Exception 
     */
    public void delete(Member m) throws Exception
    {
        accessor.delete(m.getMemberNo());
        members.remove(m);
    }
    
    public void update(Member m) throws Exception
    {
        String membertype = "senior";
        Calendar c = Calendar.getInstance();
        int age = c.get(Calendar.YEAR) - m.getBirthYear();
        if(age < 18)
        {
            membertype = "junior";
        }
        else if(age > 60)
        {
            membertype = "retiree";
        }
        m.setMemberType(membertype);
        accessor.update(m);
    }
    
    public void add(Member memb) throws SQLServerException, SQLException
    {
        int memberNo=1000;
        Calendar c = Calendar.getInstance();
        int age = c.get(Calendar.YEAR)-memb.getBirthYear();
        String membertype = "senior";
        //Determinants
        for(Member m : members)
        {
            if(m.getMemberNo()>memberNo)
            {
                memberNo = m.getMemberNo()+1;
            }
        }
        if(age < 18)
        {
            membertype = "junior";
        }
        else if(age > 60)
        {
            membertype = "retiree";
        }
        memb.setMemberType(membertype);
        accessor.add(memb);
        members.add(memb);
    }
}