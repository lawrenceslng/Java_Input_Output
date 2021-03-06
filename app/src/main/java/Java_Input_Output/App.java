/*
 * The App file will control the program, and allow user to select what runs.
 */
package Java_Input_Output;

import java.io.File;

public class App {

    /*
     * eventually allow user the following options:
     * 1. convert CSV to XML
     * 2. covert XML to CSV
     */
    public static void main(String[] args) {
        //look for file in local directory (test.csv)
        File inputFile = new File("resources\\test.csv");
        //call Reader on file
        CsvReader csvReader = new CsvReader(inputFile);
        System.out.println("Reading CSV File");
        csvReader.read();
        //call Writer
        System.out.println(csvReader.getHeaders());
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.setHeaders(csvReader.getHeaders());
        xmlWriter.setContent(csvReader.getContent());
        xmlWriter.writer();
    }
}
