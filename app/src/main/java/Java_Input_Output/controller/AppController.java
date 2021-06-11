package Java_Input_Output.controller;

import Java_Input_Output.CsvReader;
import Java_Input_Output.ShopItem;
import Java_Input_Output.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AppController {


    @GetMapping(value="/")
    public String getApp(Model model){

        //from here, we want to access the different methods we have. Should these be their own methods within this app controller, or should
        //each different reader or writer have their own controller which handles getting the methods used for file conversion?
        //ex:
        //CsvReaderController.getRead();
        System.out.println("hitting /");
        //adding a user attribute with a new user object into the model allows it to be accessible at the login template
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping(value="/home")
    public String home(HttpServletRequest request){
        //model  contains the user attribute from the login redirect. how can we access this data?
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            User user = (User) inputFlashMap.get("user");
            return "home";
        } else {
            return "/";
        }
    }

    @PostMapping("/login")
    //passing a user object as a parameter to this method allows us to access the user object from the login template
    //passing a model object allows us to add this same user object as a new attribute to be passed on during the redirect
    public RedirectView login(HttpServletRequest request,
                        @ModelAttribute User user,
                        RedirectAttributes redirectAttributes){
            redirectAttributes.addFlashAttribute("user", user);
            return new RedirectView("/home", true);
    }


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    //for testing purposes, will create mappings for reading and writing out in the open, and just navigate to see it display in a web browser.
    @RequestMapping(value= "/readCsv", method={RequestMethod.GET, RequestMethod.POST})
    public String readCsv(Model model){
        //create the file (this will be imported later on
        File csvFile = new File("C:\\Users\\alexa\\OneDrive\\Documents\\GitHub\\Java_Input_Output\\app\\src\\main\\resources\\static\\uploads\\test.csv");
        //read the csv file
        CsvReader csvReader = new CsvReader(csvFile);
        csvReader.read();
        //add the contents of the csv file to a model object to display in html template
        String username = "Alex";
        model.addAttribute("name", username);
        model.addAttribute("shopItems", csvReader.getShopItems());

        System.out.println("Println in read csv");
        return "readCSV";
    }
    @RequestMapping(value= "/uploadCsv", method={RequestMethod.GET, RequestMethod.POST})
    public String uploadCsv(Model model){

        String username = "Alex";
        model.addAttribute("name", username);
        System.out.println("Println in upload csv");
        return "uploadCSV";
    }

    @GetMapping("/writeXml")
    public String writeXml(Model model){
        //create the file (this will be imported later on
        //File csvFile = new File("C:\\Users\\alexa\\OneDrive\\Documents\\GitHub\\Java_Input_Output\\app\\src\\main\\resources\\static\\uploads\\test.xml");
        File csvFile = new File("resources\\test.xml");
        //read the csv file
        CsvReader csvReader = new CsvReader(csvFile);
        csvReader.read();
        ShopItem shopItemOne = csvReader.getShopItems().get(0);
        //add the contents of the csv file to a model object to display in html template
        String username = "Alex";
          model.addAttribute("name", username);
        model.addAttribute("category", shopItemOne.getCategory());
        System.out.println("category of shopitem: " + shopItemOne.getCategory());
        model.addAttribute("quantity", shopItemOne.getQuantity());
        model.addAttribute("amount", shopItemOne.getAmount());
        model.addAttribute("currency", shopItemOne.getCurrency());
        model.addAttribute("itemID", shopItemOne.getItemID());
        model.addAttribute("item", shopItemOne.getItem());
        model.addAttribute("description", shopItemOne.getDescription());
        System.out.println("Println in write xml");
        return "writeXml";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file)
            throws IllegalStateException,IOException {
        String baseDir = "C:\\Users\\alexa\\OneDrive\\Documents\\GitHub\\Java_Input_Output\\app\\src\\main\\resources\\static\\uploads\\";

        file.transferTo(new File(baseDir + "test.csv"));

        return "redirect:/readCsv";
    }

}
