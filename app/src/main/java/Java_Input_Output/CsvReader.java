package Java_Input_Output;
/*
 * Read in a CSV file
 */

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader extends ReaderFile{

    File csvFile;

    public CsvReader(File csvFile){
        this.csvFile = csvFile;
    }

    @Override
    public void read() {
        try (BufferedReader in =
                     new BufferedReader(new FileReader(csvFile))) {
            System.out.println("reading CSV File");
            String line;
            int count = 0;
            while((line = in.readLine()) != null) {
                if(count == 0) {
                    setHeaders(Arrays.asList(line.split(",")));
                } else {
                    setContent(Arrays.asList(line.split(",")));
                }
                count++;
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            // Handle FileNotFoundException, etc. here
        }
        System.out.println("Headers: " + getHeaders().toString());
        System.out.println("Content: " + getContent().toString());
        System.out.println("toString method: " + toString());
    }
}