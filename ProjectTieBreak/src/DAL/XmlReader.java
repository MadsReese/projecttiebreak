package DAL;

import BE.Match;
import BE.Member;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

/**
 * Reads an XML file to get the info out of it
 * @author Reese
 */
public class XmlReader
{
    private final String fileName;
    private List<Member> members;
    private List<Match> matches;
    
    public XmlReader(String filename)
    {
        this.fileName = filename;
        members = new ArrayList<>();
    }
    
    /**
     * Reads all the members in the xml-file
     * @return List of all the members in the xml
     * @throws Exception parsing errors etc.
     */
    public List<Member> getMembers() throws Exception
    {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(new File(fileName));
        XPathFactory xpfactory = XPathFactory.newInstance();
        XPath xpath = xpfactory.newXPath();
        
        int num = Integer.parseInt(xpath.evaluate("count(memberList/member)", doc));
        for (int i = 1; i <= num; i++)
        {
            int memberNo = Integer.parseInt(xpath.evaluate("memberList/member[" + i + "]/memberNo", doc));
            String firstName = xpath.evaluate("memberList/member[" + i + "]/firstName", doc);
            String lastName = xpath.evaluate("memberList/member[" + i + "]/lastName", doc);
            String address = xpath.evaluate("memberList/member[" + i + "]/address", doc);
            int birthYear = Integer.parseInt(xpath.evaluate("memberList/member[" + i + "]/birthYear", doc));
            int phoneNo = Integer.parseInt(xpath.evaluate("memberList/member[" + i + "]/phoneNo", doc));
            String email = xpath.evaluate("memberList/member[" + i + "]/email", doc);
            String memberType = xpath.evaluate("memberList/member[" + i + "]/memberType", doc);
            int DTULicenceNo = Integer.parseInt(xpath.evaluate("memberList/member[" + i + "]/DTULicenceNo", doc));

            Member m = Member.fromDataBase(memberNo, lastName, firstName, address, birthYear, phoneNo, email, memberType, DTULicenceNo);
            members.add(m);
        }
        return members;
    }
    
//    public List<Match> getMatches() throws Exception
//    {
//        
//    }
}
