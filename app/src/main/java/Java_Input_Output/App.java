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
        //What would you like to do?

        //Convert CSV to XML
        //Please enter your file name:
        //scanner function, enter file path
        File filename = null;
        new CsvToXmlConverter(filename);

        //Convert XML to CSV
    }
}
