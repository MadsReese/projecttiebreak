/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *Class created for the purpose of providing another toString for the list in the ranked interface
 * @author Jesper
 */
public class MemberContainer
{
    private Member memberObject;
    private int rank;
    
    public MemberContainer(Member memberObject, int rank)
    {
        this.memberObject = memberObject;
        this.rank = rank;
    }
    
    public String toString()
    {
        return rank + ". - " + memberObject.getFirstName() + " "+memberObject.getLastName() + " - " + memberObject.getDTUPoints() + " points.";
    }
}
