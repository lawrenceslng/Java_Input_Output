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
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlWriter extends WriterFile{

    //sub array list of csv content
    private List<String> subContent;
    private File xmlFile;
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

//            System.out.println("headers: " + this.getHeaders().toString());
//            System.out.println("content: " + this.getContent().toString());
            //begin loop through arrayLists
            int contentSize = this.getContent().size()/this.getHeaders().size();
            int start = 0;
            int end = this.getHeaders().size();
            for(int i = 0; i < contentSize; i++) {
                subContent = this.getContent().subList(start,end);
                rootElement.appendChild(createElement(this.getHeaders(), subContent, doc));
                start = end;
                end+=this.getHeaders().size();
            }
            //end loop through arrayLists
            System.out.println(rootElement.toString());
            System.out.println(rootElement.getChildNodes().toString());

            // write the content into xml file - this is done after looping through all content of list
            xmlFile = new File("inventory.xml");
            //FileOutputStream outputStream = new FileOutputStream(xmlFile);
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

//<?xml version="1.0" encoding="UTF-8"?>
//<inventory>
//	<shopItem category="">
//		<quantity></quantity>
//		<amount></amount>
//		<currency></currency>
//		<itemID></itemID>
//		<item></item>
//		<description></description>
//	</shopItem>
//</inventory>

    private static Element createElement(List<String> headers, List<String> content, Document doc){
        Element shopItem = doc.createElement("shopItem");
        //create root element first - shopItem
        Attr attr = doc.createAttribute(headers.get(0));
        attr.setValue(content.get(0));
        shopItem.setAttributeNode(attr);

        for(int i=1; i < headers.size(); i++){
            Element itemElement = doc.createElement(headers.get(i));
            itemElement.setTextContent(content.get(i));
            //System.out.println("item element: " + itemElement.getTextContent());
            shopItem.appendChild(itemElement);
        }
        return shopItem;
    }
}