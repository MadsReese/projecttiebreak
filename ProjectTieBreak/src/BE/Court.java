/*
 * 
 */
package BE;

/**
 *
 * @author boinq
 */
public class Court 
{
    int Id;
    int Number;
    String Type;
    
    private Court() throws IllegalArgumentException
    {
       
    }
    
    public static Member fromDataBase(int memberNo, String lastName, String firstname, String address, int birthYear, int phoneNo, String email, String memberType, int DTULicenceNo, int DTUPoints) throws IllegalArgumentException
    {
        Court newMemberObj = new Court();
        newMemberObj.setMemberNo(memberNo);
        newMemberObj.SetLastName(lastName);
        newMemberObj.setFirstName(firstname);
        newMemberObj.setAddress(address);
        newMemberObj.setEmail(email);
        newMemberObj.setBirthYear(birthYear);
        newMemberObj.setPhoneNo(phoneNo);
        newMemberObj.setMemberType(memberType);
        newMemberObj.setDTUPoints(DTUPoints);
        newMemberObj.setDTULicenseNo(DTULicenceNo);
        return newMemberObj;
    }
}
