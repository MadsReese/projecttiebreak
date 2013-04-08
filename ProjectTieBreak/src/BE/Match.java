/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.util.Date;

/**
 *
 * @author jesper
 */
public class Match {
    
    //instance fields
    private Date date;    
    private int[] DTULicenceNo;
    
    private Match(Date date,int... DTULicenceNo)throws IllegalArgumentException
    {
        this.date=date;
        this.DTULicenceNo = DTULicenceNo;
        if(!(this.DTULicenceNo.length==2||this.DTULicenceNo.length==2))
        {
            throw new IllegalArgumentException("ERROR - only two or four players");
        }
    }
        
    /**
     * factory method for some undetermined purpose
     * @param date the date and time the match will be played
     * @param DTULicenceNo 2 or 4 DTU Licence Numbers.
     * @return 
     */
    public static Match createNew(int... DTULicenceNo) throws IllegalArgumentException
    {
        return new Match(null,DTULicenceNo);
    }
    
    public static Match fromDateBase(Date date, int... DTULicenceNo)
    {
        return new Match(date,DTULicenceNo);
    }
    
    public Date getDate()
    {
        return date;
    }
    
    public int[] getLicenceNos()
    {
        return DTULicenceNo;
    }
}
