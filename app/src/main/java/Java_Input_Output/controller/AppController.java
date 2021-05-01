package Java_Input_Output.controller;

import Java_Input_Output.CsvReader;
import Java_Input_Output.ShopItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@Controller
public class AppController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/index")
    public String getApp(){

        //from here, we want to access the different methods we have. Should these be their own methods within this app controller, or should
        //each different reader or writer have their own controller which handles getting the methods used for file conversion?
        //ex:
        //CsvReaderController.getRead();
        return "This is the main section of our Java App";
    }

    //for testing purposes, will create mappings for reading and writing out in the open, and just navigate to see it display in a web browser.
    @GetMapping("/readCsv")
    public String readCsv(){
        //create the file (this will be imported later on
        File csvFile = new File("resources\\test.csv");
        //read the csv file
        CsvReader csvReader = new CsvReader(csvFile);
        csvReader.read();
        ShopItem shopItemOne = csvReader.getShopItems().get(0);
        //add the contents of the csv file to a model object to display in html template
        //doesn't seem like the below works. not sure how to add data from read method into html
        Model model = new ConcurrentModel();
        model.addAttribute("category", shopItemOne.getCategory());
        model.addAttribute("quantity", shopItemOne.getQuantity());
        model.addAttribute("amount", shopItemOne.getAmount());
        model.addAttribute("currency", shopItemOne.getCurrency());
        model.addAttribute("itemID", shopItemOne.getItemID());
        model.addAttribute("item", shopItemOne.getItem());
        model.addAttribute("description", shopItemOne.getDescription());
        System.out.println("Println in read csv");
        return "readCSV";
    }


}
