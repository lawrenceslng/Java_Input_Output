package Java_Input_Output;
/*
 * Write an XML file from content of CSV file
 */

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;

public class XmlWriter extends WriterFile{

    private File xmlFile;

    @Override
    public void writer() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("inventory");
            doc.appendChild(rootElement);

            for(int i = 0; i < getShopItems().size(); i++) {
                rootElement.appendChild(createElement(getShopItems().get(i), doc));
            }

            // write the content into xml file - this is done after looping through all content of list
            xmlFile = new File("inventory.xml");
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            StreamResult result = new StreamResult(xmlFile.getPath());
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Element createElement(ShopItem shopItemObj, Document doc){

        Element shopItem = doc.createElement("shopItem");

        HashMap<String,String> shopItemMap = shopItemObj.generateShopItemHashMap();

        //sort this as it will loop through hash map in a random order, so that XML is in a specific order
        for (HashMap.Entry<String,String> entry : shopItemMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            if(entry.getKey().equals("category")){
                Attr attr = doc.createAttribute(entry.getKey());
                attr.setValue(entry.getValue());
                shopItem.setAttributeNode(attr);
            } else {
                Element itemElement = doc.createElement(entry.getKey());
                itemElement.setTextContent(entry.getValue());
                shopItem.appendChild(itemElement);
            }
        }
        return shopItem;
    }
}