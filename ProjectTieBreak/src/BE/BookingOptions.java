/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Jesper
 */
public class BookingOptions
{
    private String type;
    //the date as a String formated dd-mm
    private String rentableFromDate;
    private String RentableToDate;
    private Double price;
    //the time given in minutes
    private int rentableFromTime;
    private int rentableToTime;
    
    public BookingOptions(String type, String fromDate, String toDate, double price, int fromTime, int toTime)
    {
        this.type=type;
        this.rentableFromDate=fromDate;
        this.RentableToDate=toDate;
        this.price=price;
        this.rentableFromTime=fromTime;
        this.rentableToTime=toTime;
    }

    /**
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * @return the rentableFromDate
     */
    public String getRentableFromDate()
    {
        return rentableFromDate;
    }

    /**
     * @return the RentableToDate
     */
    public String getRentableToDate()
    {
        return RentableToDate;
    }

    /**
     * @return the price
     */
    public Double getPrice()
    {
        return price;
    }

    /**
     * @return the rentableFromTime
     */
    public int getRentableFromTime()
    {
        return rentableFromTime;
    }

    /**
     * @return the rentableToTime
     */
    public int getRentableToTime()
    {
        return rentableToTime;
    }
    
    
}