package pl.camp.it.ApartHouseRegistration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.ApartHouseRegistration.session.SessionObject;

import javax.annotation.Resource;


@Controller
public class CommonController {

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model){
       model.addAttribute("isLogged",(sessionObject.getUser() != null));
        return "main";

    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultRedirect(){
        return "redirect:/main";
    }



}
