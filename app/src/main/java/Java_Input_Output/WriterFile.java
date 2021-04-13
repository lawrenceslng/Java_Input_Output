package Java_Input_Output;

import java.util.ArrayList;
import java.util.List;

public abstract class WriterFile {


    private List<String> headers = new ArrayList<>();
    private List<String> content = new ArrayList<>();

    public abstract void writer();

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
        this.content = content;
    }

    public String toString(){
        return headers.toString() + content.toString();
    }
}
