package Java_Input_Output;
/*
 * Call functions to read in a CSV file, parse this CSV files data, then convert that data into an XML file. Finally, output this XML file.
 */

import java.io.File;

public class CsvToXmlConverter{

    public File filename;

    CsvToXmlConverter(File filename){
        this.filename = filename;
    }
    //call method to read csv file
    String[] csvFileContent = CsvFileReader.readCsvFile(filename);

    //convert contents of csvFileContent to XML
    File xmlFile = XmlFileWriter.createXmlFile(csvFileContent);
}