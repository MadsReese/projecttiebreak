/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author Jesper
 */
public class BookingOptionsManager
{
    private static BookingOptionsManager instance;
    
    private BookingOptionsManager()
    {
        
    }
    
    public static BookingOptionsManager getInstance()
    {
        if(instance==null)
        {
            instance=new BookingOptionsManager();
        }
        return instance;        
    }
}
