package Java_Input_Output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Read in the content of an XML file to be converted to a CSV file.
 */
public class CsvWriter extends WriterFile{
//    private File csvFile;

    @Override
    public void writer() throws IOException {
        FileWriter csvWriter = new FileWriter("inventory.csv");
        csvWriter.append("category,quantity,amount,currency,itemID,item,description");
        csvWriter.append("\n");

        System.out.println("ShopItem Size: " + getShopItems().size());

        for(int i = 0; i < getShopItems().size(); i++) {
            //https://stackoverflow.com/questions/366202/regex-for-splitting-a-string-using-space-when-not-surrounded-by-single-or-double
            List<String> matchList = new ArrayList<String>();
            Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
            Matcher regexMatcher = regex.matcher(getShopItems().get(i).toString());
            while (regexMatcher.find()){
                if (regexMatcher.group(1) != null) {
                    // Add double-quoted string without the quotes
                    matchList.add(regexMatcher.group(1));
                } else if (regexMatcher.group(2) != null) {
                    // Add single-quoted string without the quotes
                    matchList.add(regexMatcher.group(2));
                } else {
                    // Add unquoted word
                    matchList.add(regexMatcher.group());
                }
            }
            for(int j = 0; j < matchList.size(); j++){
                csvWriter.append(matchList.get(j));
                if(j != matchList.size()-1){
                    csvWriter.append(",");
                }
            }
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}