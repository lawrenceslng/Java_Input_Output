/*
 * The App file will control the program, and allow user to select what runs.
 */
package Java_Input_Output;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class App {

    /*
     * eventually allow user the following options:
     * 1. convert CSV to XML
     * 2. covert XML to CSV
     */
    public static void main(String[] args) throws IOException {
        //look for file in local directory (test.csv)
        SpringApplication.run(App.class, args);
//        File inputFile = new File("resources/test.xml");
//        String fileType = inputFile.getName().substring(inputFile.getName().length()-3);
//        if(fileType.equals("csv")){
//            //call Reader on file
//            CsvReader csvReader = new CsvReader(inputFile);
//            try{
//                csvReader.read();
//            }
//            catch(Exception e){
//                return;
//            }
//            //call Writer
//            System.out.println(csvReader.getHeaders());
//            XmlWriter xmlWriter = new XmlWriter();
//            xmlWriter.setHeaders(csvReader.getHeaders());
//            xmlWriter.setShopItems(csvReader.getShopItems());
//            xmlWriter.writer();
//        }
//        else if (fileType.equals("xml")){
//            XmlReader xmlReader = new XmlReader(inputFile);
//            try{
//                xmlReader.read();
//            }
//            catch(Exception e){
//                return;
//            }
//            //call Writer
//            System.out.println("Getting Shop Items: " + xmlReader.getShopItems());
//            CsvWriter csvWriter = new CsvWriter();
//            csvWriter.setHeaders(xmlReader.getHeaders());
//            csvWriter.setShopItems(xmlReader.getShopItems());
//            csvWriter.writer();
//        }
//        else {
//            System.out.println("Input File Type not supported");
//        }

        }
    }
