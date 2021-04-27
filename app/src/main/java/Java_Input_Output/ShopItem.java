package Java_Input_Output;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

enum Currency{
    USD, GBP, EUR;
}
enum Category{
    SNACKS, MEATS, GRAINS;
}

public class ShopItem {

    private Category category;
    private int quantity;
    private int amount;
    private Currency currency;
    private int itemID;
    private String item;
    private String description;

    public ShopItem(List<String> content) throws Exception {

        if(content.get(1).isEmpty() || content.get(2).isEmpty() || content.get(4).isEmpty() || content.get(5).isEmpty()){
            throw new Exception("error with blank values");
        }
        if(!Arrays.stream(Currency.values()).anyMatch(e -> e.name().equals(content.get(3).toUpperCase())) || !Arrays.stream(Category.values()).anyMatch(e -> e.name().equals(content.get(0).toUpperCase()))){
            throw new Exception("error with enum values");
        }
        try {
            this.category = Category.valueOf(content.get(0).toUpperCase());
            this.quantity = Integer.parseInt(content.get(1));
            this.amount = Integer.parseInt(content.get(2));
            this.currency = Currency.valueOf(content.get(3).toUpperCase());
            this.itemID = Integer.parseInt(content.get(4));
            this.item = content.get(5);
            this.description = content.get(6);
        } catch(IllegalArgumentException e){
            System.out.println("value is not correct");
            System.exit(1);
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return getCategory().toString() + " " + getQuantity() + " " + getAmount() + " " + getCurrency().toString() + " " + getItemID() + " " + getItem() + " " + getDescription();
    }

    public HashMap<String,String> generateShopItemHashMap(){
        HashMap<String,String> shopItemMap = new HashMap<>();
        for (Field f : this.getClass().getDeclaredFields()) {
            try {
                shopItemMap.put(f.getName(), String.valueOf(f.get(this)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return shopItemMap;
    }

}
