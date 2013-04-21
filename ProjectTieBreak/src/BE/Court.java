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
    private int id;
    private int number;
    private String courtType;
    
    private Court() throws IllegalArgumentException
    {
       
    }
    
    public static Court fromDataBase(int id, int number, String courtType) throws IllegalArgumentException
    {
        Court newMemberObj = new Court();
        newMemberObj.setId(id);
        newMemberObj.setNumber(number);
        newMemberObj.setCourtType(courtType);        
        return newMemberObj;
    }
    
    /**
     * @param number the number to set
     */
    public void setNumber(int number)
    {
        this.number = number;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * @param courtType the courtType to set
     */
    public void setCourtType(String courtType)
    {
        this.courtType = courtType;
    }
    
    
}
