/*
 * 
 */
package BE;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author boinq
 */
public class Booking 
{
    private int bookingId;
    private int courtId;
    private GregorianCalendar fromDate;
    private GregorianCalendar toDate;
    private ArrayList<Integer> memberId;
    
    private Booking() throws IllegalArgumentException
    {
       
    }
    
    public static Booking createSimple(int bookingId, int courtId, GregorianCalendar fromDate,GregorianCalendar toDate, ArrayList<Integer> memberId)
    {
        Booking newBookingObj = new Booking();
        newBookingObj.setBookingId(bookingId);
        newBookingObj.setCourtId(courtId);
        newBookingObj.setFromDate(fromDate);
        newBookingObj.setToDate(toDate);
        
        newBookingObj.setMemberId(memberId);
             
        return newBookingObj;
    }
    
    public static Booking createNew(int courtId, GregorianCalendar fromDate,GregorianCalendar toDate, ArrayList<Integer> memberId)
    {
        Booking newBookingObj = new Booking();        
        newBookingObj.setCourtId(courtId);
        newBookingObj.setFromDate(fromDate);
        newBookingObj.setToDate(toDate);        
        newBookingObj.setMemberId(memberId);
             
        return newBookingObj;
    }
    


    private void setBookingId(int bookingId) 
    {
        this.bookingId=bookingId;
    }
    
    private void setMemberId(ArrayList<Integer> memberId) 
    {
        this.memberId=memberId;
    }

    private void setCourtId(int courtId) {
        this.courtId=courtId;
    }
        
    public int getBookingId()
    {
        return bookingId;
    }
    
    public ArrayList<Integer> getMemberId()
    {
        return memberId;
    }

    
    public int getCourtId()
    {
        return courtId;
    }
    

    /**
     * @return the fromDate
     */
    public GregorianCalendar getFromDate()
    {
        return fromDate;
    }

    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(GregorianCalendar fromDate)
    {
        this.fromDate = fromDate;
    }

    /**
     * @return the toDate
     */
    public GregorianCalendar getToDate()
    {
        return toDate;
    }

    /**
     * @param toDate the toDate to set
     */
    public void setToDate(GregorianCalendar toDate)
    {
        this.toDate = toDate;
    }

    
}
