package Java_Input_Output;
/*
 * Read in a CSV file.
 */

import java.io.File;

public class CsvFileReader {
    static String[] csvDataArray;
    public static String[] readCsvFile(File filename){


        //will need to maybe count the # of elements from the csv file before initalizing the array. 7 based on README csv content.
        csvDataArray = new String[7];
        return csvDataArray;
    }

}