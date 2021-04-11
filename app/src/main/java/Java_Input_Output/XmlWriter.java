package Java_Input_Output;
/*
 * Write an XML file from content of CSV file
 */

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XmlWriter extends WriterFile{

    @Override
    public void writer() {
        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("inventory");
            doc.appendChild(rootElement);

            //begin loop through arrayLists
            Element shopItem = doc.createElement("shopItem");
            rootElement.appendChild(shopItem);

            // setting attribute to element
            Attr attr = doc.createAttribute("category");
            //needs to be value from arraylist & need to loop through to find category value
            attr.setValue(""); //value from content for category header
            shopItem.setAttributeNode(attr);

            //loop through lists to fill out elements and text values
            //this would be the header value from arraylist
            Element itemElement = doc.createElement("quantity");
            //content from arraylist
            itemElement.appendChild(doc.createTextNode("10"));
            shopItem.appendChild(itemElement);
            //end loop through arrayLists


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\cars.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}