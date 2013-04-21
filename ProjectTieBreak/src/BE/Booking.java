/*
 * 
 */
package BE;

/**
 *
 * @author boinq
 */
public class Booking 
{
    private int courtId;
    private int fromDate;
    private int toDate;
    private int memberId;
    
    private Booking() throws IllegalArgumentException
    {
       
    }
    
    public static Booking createSimple(int courtId, int fromDate, int toDate, int memberId)
    {
        Booking newBookingObj = new Booking();
        newBookingObj.setCourtId(courtId);
        newBookingObj.setFromDate(fromDate);
        newBookingObj.setToDate(toDate);
        newBookingObj.setMemberId(memberId);
        return newBookingObj;
    }

    private void setMemberId(int memberId) {
        this.memberId=memberId;
    }

    private void setToDate(int toDate) {
        this.toDate=toDate;
    }

    private void setFromDate(int fromDate) {
        this.fromDate=fromDate;
    }

    private void setCourtId(int courtId) {
        this.courtId=courtId;
    }
    
    public int getMemberId()
    {
        return memberId;
    }
    
    public int getToDate()
    {
        return toDate;
    }
    
    public int getFromDate()
    {
        return fromDate;
    }
    
    public int getCourtId()
    {
        return courtId;
    }
    
    
}
