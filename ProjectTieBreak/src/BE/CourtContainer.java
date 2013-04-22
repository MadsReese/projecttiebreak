/*
 * 
 */
package BE;

/**
 *
 * @author boinq
 */
public class CourtContainer {
    private Court courtObject;
    
    public CourtContainer(Court courtObject)
    {
        this.courtObject = courtObject;
    }
    
    public String toString()
    {
        return courtObject.getNumber() + " - " + courtObject.getCourtType();
    }
    
    public Court getCourt()
    {
        return courtObject;
    }
}
