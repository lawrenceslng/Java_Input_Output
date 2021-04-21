package Java_Input_Output;
/*
 * Read in a CSV file
 */

import java.io.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class CsvReader extends ReaderFile{

    File csvFile;
    List<String> content;

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
                    content = Arrays.asList(line.split(","));
                    System.out.println(content.toString());
                    ShopItem shopItem = new ShopItem(content);
                    System.out.println("shopItem item: " + shopItem.getItem());
                    addShopItems(shopItem);
                }
                count++;
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            // Handle FileNotFoundException, etc. here
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
            return;
        }
        System.out.println("Headers: " + getHeaders().toString());
        System.out.println("ShopItem toString method: " + getShopItems().get(0).toString());
        System.out.println("ReaderFile toString method: " + toString());
    }
}