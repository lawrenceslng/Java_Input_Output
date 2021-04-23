package Java_Input_Output;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CsvReaderTest {
    private File csvFile;
    @Test
    public void read() throws Exception {
        csvFile = new File("C:\\Users\\alexa\\OneDrive\\Documents\\GitHub\\Java_Input_Output\\app\\src\\test\\resources\\testHeader.csv");
        CsvReader csvReader = new CsvReader(csvFile);
        //Test Headers
        csvReader.read();
        Assertions.assertEquals("[category, quantity, amount, currency, itemID, item, description]",csvReader.getHeaders().toString());
        //Assert.assertEquals("[category, quantity, amount, currency, itemID, item, description]",csvReader.getHeaders().toString());

        csvFile = new File("resources\\testShopItem.csv");
        //Test ShopItems
        List<String> content1 = Arrays.asList("snacks","10","500","USD","123456789","pringles","'so stackable'");
        List<ShopItem> shopItemList = new ArrayList<>();
        ShopItem shopItem1 = new ShopItem(content1);
        shopItemList.add(shopItem1);
        List<String> content2 = Arrays.asList("meats","5","100","USD","987654321","chicken","'lean chicken'");
        ShopItem shopItem2 = new ShopItem(content2);
        shopItemList.add(shopItem2);
        List<String> content3 = Arrays.asList("grains","7","1000","USD","918273645","bread","'whole wheat'");
        ShopItem shopItem3 = new ShopItem(content3);
        shopItemList.add(shopItem3);
        Assertions.assertEquals(shopItemList.toString(),csvReader.getShopItems().toString());


    }
}