package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/spittr", "/spittr/homepage"})
public class HomeController {

    //@RequestMapping(value="/", method = RequestMethod.GET)
    //we moved @RequestMapping to class-level which applies to all handler methods in controller
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }

}
