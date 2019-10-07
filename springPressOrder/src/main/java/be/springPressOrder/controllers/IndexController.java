package be.springPressOrder.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String menu(){
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }


    @RequestMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("error", true);
        return "login";
    }


    /*@RequestMapping("/")
    String index() {
        return "index";
    }

    /*@RequestMapping("/login")
    public String login() {
        return "login";
    }*/

/*    @RequestMapping("/403")
    public String error403() {
        return "/error/403";
    }
*/
  /*  @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("error", true);
        return "login";
    }*/

}
