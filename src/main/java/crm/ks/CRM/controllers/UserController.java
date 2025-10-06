package crm.ks.CRM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public List<String> returnList(){
        return Arrays.asList("Test", "List");
    }
}
