/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Reese
 */
public class Member
{
    //Instance fields
    private int memberNo;
    private String lastName;
    private String firstName;
    private String address;
    private int birthYear;
    private int phoneNo;
    private String email;
    private enum MemberType {junior, senior, recreational, retiree};
    private MemberType memberType;
    private int DTULicenceNo;
    
    private Member(int memberNo, String lastName, String firstname, String address, int birthYear, int phoneNo, String email, String memberType, int DTULicenceNo) throws IllegalArgumentException
    {
        this.memberNo=memberNo;
        this.lastName=lastName;
        this.firstName=firstName;
        this.address=address;
        this.birthYear=birthYear;
        this.phoneNo=phoneNo;
        this.email=email;
        switch(memberType)
        {
            case "junior": this.memberType = this.memberType.junior; break;
            case "senior": this.memberType = this.memberType.senior; break;
            case "recreational": this.memberType = this.memberType.recreational; break;
            case "retiree": this.memberType = this.memberType.retiree; break;
            default: throw new IllegalArgumentException("ERROR - invalid member type");
        }        
        this.DTULicenceNo=DTULicenceNo;
    }
    
    public static Member fromDataBase(int memberNo, String lastName, String firstname, String address, int birthYear, int phoneNo, String email, String memberType, int DTULicenceNo) throws IllegalArgumentException
    {
        return new Member(memberNo, lastName, firstname, address, birthYear, phoneNo, email,  memberType, DTULicenceNo);
    }
    
    /**
     * @return the memberNo
     */
    public int getMemberNo()
    {
        return memberNo;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    public void SetLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }

    /**
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * @return the birthYear
     */
    public int getBirthYear()
    {
        return birthYear;
    }

    /**
     * @return the phoneNo
     */
    public int getPhoneNo()
    {
        return phoneNo;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @return the DTULicenceNo
     */
    public int getDTULicenceNo()
    {
        return DTULicenceNo;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(int phoneNo)
    {
        this.phoneNo = phoneNo;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }   
}