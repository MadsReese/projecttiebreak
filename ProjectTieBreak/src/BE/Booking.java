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
    private GregorianCalendar dateAndTime;
    private ArrayList<Integer> memberId;
    
    private Booking() throws IllegalArgumentException
    {
       
    }
    
    public static Booking createSimple(int bookingId, int courtId, GregorianCalendar dateAndTime, int... memberId)
    {
        Booking newBookingObj = new Booking();
        newBookingObj.setBookingId(bookingId);
        newBookingObj.setCourtId(courtId);
        
        
        newBookingObj.setMemberId(memberId);
             
        return newBookingObj;
    }
    
    private void setDateAndTime(GregorianCalendar dateAndTime)
    {
        this.dateAndTime = dateAndTime;
    }

    private void setBookingId(int bookingId) {
        this.bookingId=bookingId;
    }
    
    private void setMemberId(int[] memberId) {
        this.memberId=new ArrayList();
        for(int id: memberId)
        {
            this.memberId.add(new Integer(id));
        }
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
    
    public GregorianCalendar getDateAndTime()
    {
        return dateAndTime;
    }

    
}
