package be.springPressOrder.controllers;

import be.springPressOrder.domain.Client;
import be.springPressOrder.domain.User;
import be.springPressOrder.services.ClientService;
import be.springPressOrder.services.PressSystemService;
import be.springPressOrder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class FruitEigenaarController {
    private PressSystemService pressSystemService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private void setPressSystemService(PressSystemService pressSystemService){this.pressSystemService = pressSystemService;}

    //Mapping voor een registratie pagina
    @RequestMapping(value = "/fruiteigenaar/registratie", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("objUser", new User());
        return "fruiteigenaarregistratie";
    }
    
    //Mapping voor het maken van een user
    @RequestMapping(value = "/fruiteigenaar/create", method = RequestMethod.POST)
    public String saveOrder(@ModelAttribute("objUser") @Valid User user,
                            BindingResult result, ModelMap model) {
        if (result.hasErrors()) return "fruiteigenaarregistratie";  // fouten op de form => form opnieuw tonen
        user.setRole("USER");
        userService.saveUser(user);
        return "redirect:/";
    }
}
