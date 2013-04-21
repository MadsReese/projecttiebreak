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
    private int bookingId;
    private int courtId;
    private int fromDate;
    private int toDate;
    private int memberId;
    private int time;
    
    private Booking() throws IllegalArgumentException
    {
       
    }
    
    public static Booking createSimple(int bookingId, int courtId, int fromDate, int toDate, int memberId, int time)
    {
        Booking newBookingObj = new Booking();
        newBookingObj.setBookingId(bookingId);
        newBookingObj.setCourtId(courtId);
        newBookingObj.setFromDate(fromDate);
        newBookingObj.setToDate(toDate);
        newBookingObj.setMemberId(memberId);
        newBookingObj.setTime(time);        
        return newBookingObj;
    }

    private void setBookingId(int bookingId) {
        this.bookingId=bookingId;
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
    
    private void setTime(int time) {
        this.time=time;
    }
    
    public int getBookingId()
    {
        return bookingId;
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
    
    public int getTime()
    {
        return time;
    }    
    
    
}
