package pl.camp.it.ApartHouseRegistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.ApartHouseRegistration.model.User;
import pl.camp.it.ApartHouseRegistration.service.IUserService;


@Controller
public class AuthenticationController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)

    public String loginForm(Model model){
        model.addAttribute("admin", new User());
        return "login";

    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user){
        boolean authenticationResult = userService.authenticate(user);
        if(authenticationResult ){
            return "redirect:/main";
        }else {
            return "redirect:/login";

        }
    }




}
