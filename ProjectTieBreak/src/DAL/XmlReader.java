/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Member;
import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

/**
 *
 * @author Reese
 */
public class XmlReader
{
    private final String fileName;
    private List<Member> members;
    
    public XmlReader(String filename)
    {
        this.fileName = filename;
    }
    
    public List<Member> getAll() throws Exception
    {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(new File(fileName));
        XPathFactory xpfactory = XPathFactory.newInstance();
        XPath xpath = xpfactory.newXPath();
        
        int num = Integer.parseInt(xpath.evaluate("count(list/member)", doc));
        
        for (int i = 0; i < num; i++)
        {
            int memberNo = Integer.parseInt(xpath.evaluate("list/member[" + i + "]/memberNo", doc));
            String firstName = xpath.evaluate("list/member[" + i + "]/firstName", doc);
            String lastName = xpath.evaluate("list/member[" + i + "]/lastName", doc);
            String address = xpath.evaluate("list/member[" + i + "]/address", doc);
            int birthYear = Integer.parseInt(xpath.evaluate("list/member[" + i + "]/birthYear", doc));
            int phoneNo = Integer.parseInt(xpath.evaluate("list/member[" + i + "]/phoneNo", doc));
            String email = xpath.evaluate("list/member[" + i + "]/email", doc);
            String memberType = xpath.evaluate("list/member[" + i + "]/memberType", doc);
            int DTULicenceNo = Integer.parseInt(xpath.evaluate("list/member[" + i + "]/DTULicenceNo", doc));
            Member m = Member.fromDataBase(memberNo, lastName, firstName, address, birthYear, phoneNo, email, memberType, DTULicenceNo);
            members.add(m);
        }
        return members;
    }
}
