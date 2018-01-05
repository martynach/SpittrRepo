package spittr.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.Spitter;
import spittr.data.ISpitterRepository;

import javax.validation.Valid;


@Controller
@RequestMapping("/spittr/spitter")
public class SpitterController {

    private ISpitterRepository spitterRepository;

    @Autowired
    public SpitterController(ISpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@Valid Spitter spitter, BindingResult bindingResults) {

        if(bindingResults.hasErrors()) {
            System.out.println("Validation errors");
            return "registerForm";
        }


        spitterRepository.save(spitter);

        return "redirect:/spittr/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showUserProfile(@PathVariable(value = "username") String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute("spitter", spitter);
        return "profile";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {

        model.addAttribute(new Spitter());
        return "registerForm";
    }
}
