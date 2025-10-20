package crm.ks.CRM.controllers;

import crm.ks.CRM.io.ProfileRequest;
import crm.ks.CRM.io.ProfileResponse;
import crm.ks.CRM.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //endpoint linked to react front-end
    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String returnList(){
        return "Back-End";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse registerNewUser(@Valid @RequestBody ProfileRequest profileRequest
    ){
        log.info(profileRequest.getUsername());
        ProfileResponse response = userService.createUser(profileRequest);
        //TODO email service verification + welcome message
        return response;
    }
}
