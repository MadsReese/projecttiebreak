/*
 * 
 */
package BE;

/**
 *
 * @author boinq
 */
public class BookingContainer 
{
    private Booking bookingObject;
    
    public BookingContainer(Booking bookingObject)
    {
        this.bookingObject = bookingObject;
    }
    
    public String toString()
    {
        return bookingObject.getMemberId() + " - " + bookingObject.getCourtId() + " - " + bookingObject.getFromDate();
    }
}
