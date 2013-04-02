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
    private int memberNo;
    private String lastName;
    private String firstName;
    private String address;
    private int birthYear;
    private int phoneNo;
    private String email;
    private enum memberType {junior, senior, recreational, retiree};
    private int DTULicenceNo;

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