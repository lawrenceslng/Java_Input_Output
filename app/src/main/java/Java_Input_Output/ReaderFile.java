package Java_Input_Output;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class ReaderFile {

    private List<String> headers = new ArrayList<>();
    private List<String> content = new ArrayList<>();

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

//    protected boolean validateHeaders(List<String> headers){
//        for(int i = 0; i < headers.size(); i++){
//            if(){
//                return false;
//            }
//        }
//        return true;
//    }

    public String toString(){
        return headers.toString() + content.toString();
    }

    private enum headerList{
        category,
        quantity,
        amount,
        currency,
        itemID,
        item,
        description
    }

}
