package crm.ks.CRM.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    //endpoint linked to react front-end
    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String returnList(){
        return "Back-End";
    }
}
