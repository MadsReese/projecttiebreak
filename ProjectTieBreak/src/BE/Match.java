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
    
    private Date date;    
    private int[] DTULicenceNo;
    
    private Match(Date date,int... DTULicenceNo)
    {
        this.date=date;
        this.DTULicenceNo = DTULicenceNo;
        if(!(this.DTULicenceNo.length==2||this.DTULicenceNo.length==2))
        {
            throw new IllegalArgumentException("ERROR - only two or four players");
        }
    }
        
    public static Match someName(Date date,int... DTULicenceNo)
    {
        return new Match(date,DTULicenceNo);
    }
}
