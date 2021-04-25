package Java_Input_Output;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Read an XML file who's content will later be converted to CSV.
 */
public class XmlReader extends ReaderFile{

    File xmlFile;
    List<String> content;
    String contentArr[] = new String[7];

    public XmlReader(File xmlFile){
        this.xmlFile = xmlFile;
    }

    @Override
    public void read() {
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler(){
                boolean bQuantity = false;
                boolean bAmount = false;
                boolean bCurrency = false;
                boolean bItemID = false;
                boolean bItem = false;
                boolean bDescription = false;

                public void startElement(
                        String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    if (qName.equalsIgnoreCase("shopItem")) {
                        String category = attributes.getValue("category");
                        contentArr[0] = category;
                    } else if (qName.equalsIgnoreCase("quantity")) {
                        bQuantity = true;
                    } else if (qName.equalsIgnoreCase("amount")) {
                        bAmount = true;
                    } else if (qName.equalsIgnoreCase("currency")) {
                        bCurrency = true;
                    }
                    else if (qName.equalsIgnoreCase("itemID")) {
                        bItemID = true;
                    }
                    else if (qName.equalsIgnoreCase("item")) {
                        bItem = true;
                    }
                    else if (qName.equalsIgnoreCase("description")) {
                        bDescription = true;
                    }
                }
                public void endElement(String uri,
                                       String localName, String qName) throws SAXException {

                    if (qName.equalsIgnoreCase("shopItem")) {
                        System.out.println("End Element :" + qName);
                        try {
                            content = new ArrayList(Arrays.asList(contentArr));
                            System.out.println("Content: " + content);
//                            System.out.println("contentArr: " + contentArr.toString());
                            ShopItem shopItem = new ShopItem(content);
//                            System.out.println("shopItem item: " + shopItem.getItem());
                            addShopItems(shopItem);
                            content.clear();
//                            System.out.println("Content: " + content);
                            Arrays.fill(contentArr, null);
//                            System.out.println("contentArr: " + contentArr.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    String placeholder = new String(ch, start, length);
                    if (bQuantity) {
                        System.out.println("Quantity: " + new String(ch, start, length));
                        contentArr[1] = placeholder;
                        bQuantity = false;
                    } else if (bAmount) {
                        System.out.println("Amount: " + new String(ch, start, length));
                        contentArr[2] = placeholder;
                        bAmount = false;
                    } else if (bCurrency) {
                        System.out.println("Currency: " + new String(ch, start, length));
                        contentArr[3] = placeholder;
                        bCurrency = false;
                    } else if (bItemID) {
                        System.out.println("ItemID: " + new String(ch, start, length));
                        contentArr[4] = placeholder;
                        bItemID = false;
                    }
                    else if (bItem) {
                        System.out.println("Item: " + new String(ch, start, length));
                        contentArr[5] = placeholder;
                        bItem = false;
                    }
                    else if (bDescription) {
                        System.out.println("Description: " + new String(ch, start, length));
                        contentArr[6] = placeholder;
                        bDescription = false;
                    }
                }
            };
            saxParser.parse(xmlFile, handler);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}