package Java_Input_Output;

import java.util.ArrayList;
import java.util.List;

public abstract class ReaderFile {

    private List<String> headers = new ArrayList<>();
    private List<String> content = new ArrayList<>();
    private List<ShopItem> shopItems = new ArrayList<ShopItem>();

    public abstract void read();

    protected List<String> getHeaders() {
        return headers;
    }

    protected void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    protected List<String> getContent() {
        return content;
    }

    protected void setContent(List<String> content) {
        if(this.content == null){
            this.content = content;
        } else {
            this.content.addAll(content);
        }
    }

    public List<ShopItem> getShopItems() {
        return shopItems;
    }

    public void setShopItems(List<ShopItem> shopItems){
        this.shopItems = shopItems;
    }


    public void addShopItems(ShopItem shopItem) {
        this.shopItems.add(shopItem);
    }

    public void removeShopItems(ShopItem shopItem) {
        this.shopItems.remove(shopItem);
    }


    public String toString(){
        return headers.toString() + content.toString();
    }

}
