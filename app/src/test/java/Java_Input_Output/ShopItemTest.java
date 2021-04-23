package Java_Input_Output;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ShopItemTest {

    @Test
    public void testShopItmeConstructor() throws Exception {

        List<String> content = Arrays.asList("SNACKS","10","500","usd","123456789","pringles","'so stackable'");

        ShopItem shopItem = new ShopItem(content);
        assertEquals(Category.valueOf(content.get(0).toUpperCase()),shopItem.getCategory());
        assertEquals(Integer.parseInt(content.get(1)),shopItem.getQuantity());
        assertEquals(Integer.parseInt(content.get(2)),shopItem.getAmount());
        assertEquals(Currency.valueOf(content.get(3).toUpperCase()),shopItem.getCurrency());
        assertEquals(Integer.parseInt(content.get(4)),shopItem.getItemID());
        assertEquals(content.get(5),shopItem.getItem());
        assertEquals(content.get(6),shopItem.getDescription());

    }
}