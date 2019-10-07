package be.springPressOrder.controllers;

import be.springPressOrder.Data.RequestTechnicianData;
import be.springPressOrder.Data.ScheduleData;
import be.springPressOrder.domain.Technician;
import be.springPressOrder.domain.User;
import be.springPressOrder.services.PressSystemService;
import be.springPressOrder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.ParseException;


@Controller
public class TechnicianController {

    private PressSystemService pressSystemService;

    private UserService userService;

    @Autowired
    private void setPressSystemService(PressSystemService pressSystemService){this.pressSystemService = pressSystemService;}

    @Autowired
    private void setUserService(UserService userService){this.userService = userService;}

    @RequestMapping(value = "/technician")
    public String listTechnicianRequets(Model model){
        User user = userService.getAuthenticatedUser();
        if(user.getRole() == "ROLE_TECHNICIAN"){
            Technician technician = (Technician) user;
            model.addAttribute("listRequests",pressSystemService.getRequestTechnicianByTechnician(technician));
        }
        else
            model.addAttribute("listRequests",pressSystemService.listAllRequestTechnicians());
        return "requests";
    }

    @RequestMapping(value = "/request/new", method = RequestMethod.GET)
    public String getNewRequest(Model model)
    {
        model.addAttribute("objRequest",new RequestTechnicianData());
        model.addAttribute("listTechnicians",pressSystemService.listAllTechnicians());
        return "requestForm";
    }

    @RequestMapping(value = "request", method = RequestMethod.POST)
    public String saveRequest(@Valid RequestTechnicianData requestTechnician, Errors errors, Model model){
        String message="";
        try{
            if(errors.hasErrors()){
                message = "Correct input errors please";
                throw new IllegalArgumentException();
            }
            pressSystemService.processRequestTechnician(requestTechnician);
        }
        catch(IllegalArgumentException e){

        }
        if(message != "") {
            model.addAttribute("message", message);
            model.addAttribute("objRequest",requestTechnician);
            model.addAttribute("listTechnicians",pressSystemService.listAllTechnicians());
            return "requestForm";
        }
        return "redirect:/machines";
    }

    @RequestMapping(value = "requests", method = RequestMethod.GET)
    public String showRequest(Model model){
        model.addAttribute("listRequests",pressSystemService.listAllRequestTechnicians());
        return "requests";
    }

    @RequestMapping(value = "technician/delete{id}")
    public String deleteRequest(@PathVariable Integer id, Model model){
        pressSystemService.deleteRequest(id);
        return "redirect:/technician";
    }

}
