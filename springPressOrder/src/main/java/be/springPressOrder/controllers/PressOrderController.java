package be.springPressOrder.controllers;

import be.springPressOrder.Data.PressOrderData;
import be.springPressOrder.domain.PressOrder;
import be.springPressOrder.services.PressSystemService;
import be.springPressOrder.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Slf4j
@Controller
//@PostAuthorize("#model.get('ROL_USER').user.id == authentication.principal.id")
//@Secured({"ROL_USER"})
public class PressOrderController {

    private PressSystemService pressSystemService;
    private UserService userService;

    @Autowired
    public void setPressOrderService(PressSystemService pressSystemService) {
        this.pressSystemService = pressSystemService;
    }

    @Autowired
    public void setUserService(UserService userService){this.userService = userService;}

    @RequestMapping(value = "/pressorders", method = RequestMethod.GET)
    @PostAuthorize("#model.get('rol').persoon.emailadres == authentication.principal.username")
    public String list(Model model) {
        String role = userService.getAuthenticatedUser().getRole();
        if(role.equals("ROLE_USER"))
            model.addAttribute("pressOrders", pressSystemService.listAllPressOrdersByUser(userService.getAuthenticatedUser().getId()));
        else
            model.addAttribute("pressOrders", pressSystemService.listAllPressOrders());
        model.addAttribute("role", role);
        return "pressorders";
    }

    @RequestMapping("pressorder/{id}")
    public String showPressOrder(@PathVariable Integer id, Model model) {
        model.addAttribute("pressOrder", pressSystemService.getPressOrderById(id));
       // model.addAttribute("predictedAmountOfJuice",pressSystemService.predictAmountOfJuice(id));
        return "pressordersshow";
    }

    @RequestMapping("pressorder/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("pressOrder", pressSystemService.getPressOrderById(id));
        return "pressorderform";
    }

    @RequestMapping("pressorder/new")
    public String newPressOrder(Model model) {
        model.addAttribute("objPressOrder", new PressOrderData());
        model.addAttribute("objFruits",pressSystemService.listAllFruits());
        return "pressorderform";
    }

    @RequestMapping(value = "pressOrder", method = RequestMethod.POST)
    public String savePressOrder(@Valid PressOrderData pressOrder, Errors errors, Model model) {
        String message="";

        switch(pressOrder.fruitId) {
            //appel
            case 1:
                if(pressOrder.fruitAmount == null)
                    message = "Gelieve een aantal appels in te geven";
                if(pressOrder.fruitAmount <=2)
                    message = "Het minimum aantal appelen is 3";
                break;
            //peer
            case 2:
                if(pressOrder.fruitAmount == null)
                    message = "Gelieve een waarde in te geven";
                if(pressOrder.fruitAmount <=3)
                    message = "Het minimum aantal peren is 4";
                break;
        }

        if(!message.equals("")){
            model.addAttribute("message",message);
            model.addAttribute("objFruits",pressSystemService.listAllFruits());
            model.addAttribute("objPressOrder",pressOrder);
            return "pressorderform";
        }
        pressOrder.setUserId(userService.getAuthenticatedUser().getId());
        PressOrder newPressOrder = pressSystemService.processPressOrder(pressOrder);
        return "redirect:/pressorder/" + newPressOrder.getId();
    }

    @RequestMapping("pressorder/delete/{id}")
    public String delete(@PathVariable Integer id) {
        pressSystemService.deletePressOrder(id);
        return "redirect:/pressorders";
    }

    @RequestMapping("pressorder/cancel/{id}")
    public String cancel(@PathVariable Integer id) {
        pressSystemService.deletePressOrder(id);
        return "redirect:/pressorders";
    }
}
