package DAL;

import BE.Member;
import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Reese
 */
public class XmlWriter
{
    private final String filename;
    
    public XmlWriter(String filename)
    {
        this.filename = filename;
    }
    
    public void writeToXML(List<Member> members) throws Exception
    {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        
        Document doc = docBuilder.newDocument();
        Element rootElementMember = doc.createElement("memberList");
        doc.appendChild(rootElementMember);

        for(Member m : members)
        {
            Element member = doc.createElement("member");
            rootElementMember.appendChild(member);
            
            Element id = doc.createElement("memberNo");
            id.appendChild(doc.createTextNode("" + m.getMemberNo()));
            member.appendChild(id);
            
            Element firstname = doc.createElement("firstName");
            firstname.appendChild(doc.createTextNode(m.getFirstName()));
            member.appendChild(firstname);
            
            Element lastName = doc.createElement("lastName");
            lastName.appendChild(doc.createTextNode(m.getLastName()));
            member.appendChild(lastName);
            
            Element address = doc.createElement("address");
            address.appendChild(doc.createTextNode(m.getAddress()));
            member.appendChild(address);
            
            Element birthYear = doc.createElement("birthYear");
            birthYear.appendChild(doc.createTextNode("" + m.getBirthYear()));
            member.appendChild(birthYear);
            
            Element phoneNo = doc.createElement("phoneNo");
            phoneNo.appendChild(doc.createTextNode("" + m.getPhoneNo()));
            member.appendChild(phoneNo);
            
            Element email = doc.createElement("email");
            email.appendChild(doc.createTextNode(m.getEmail()));
            member.appendChild(email);
            
            Element memberType = doc.createElement("memberType");
            memberType.appendChild(doc.createTextNode(m.getMemberType()));
            member.appendChild(memberType);
            
            Element DTUNo = doc.createElement("DTULicenceNo");
            DTUNo.appendChild(doc.createTextNode("" + m.getDTULicenceNo()));
            member.appendChild(DTUNo);
            
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            
            transformer.transform(source, result);
        }
    }
}
