package Java_Input_Output;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;


public class ShopItemTest {

    @Test
    public void testShopItemConstructor() throws Exception {

        List<String> content = Arrays.asList("SNACKS","10","500","usd","123456789","pringles","'so stackable'");

        ShopItem shopItem = new ShopItem(content);
        Assertions.assertEquals(Category.valueOf(content.get(0).toUpperCase()),shopItem.getCategory());
        Assertions.assertEquals(Integer.parseInt(content.get(1)),shopItem.getQuantity());
        Assertions.assertEquals(Integer.parseInt(content.get(2)),shopItem.getAmount());
        Assertions.assertEquals(Currency.valueOf(content.get(3).toUpperCase()),shopItem.getCurrency());
        Assertions.assertEquals(Integer.parseInt(content.get(4)),shopItem.getItemID());
        Assertions.assertEquals(content.get(5),shopItem.getItem());
        Assertions.assertEquals(content.get(6),shopItem.getDescription());

    }
}