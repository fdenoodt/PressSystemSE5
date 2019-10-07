package be.springPressOrder.controllers;

import be.springPressOrder.Data.OrderData;
import be.springPressOrder.Data.ScheduleData;
import be.springPressOrder.domain.Order;
import be.springPressOrder.services.PressSystemService;
import be.springPressOrder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.ParseException;

@Controller
public class OrderController {


    private PressSystemService pressSystemService;
    private UserService userService;

    @Autowired
    public void setPressSystemService(PressSystemService pressSystemService) {
        this.pressSystemService = pressSystemService;
    }

    @Autowired
    public void setUserService(UserService userService){this.userService = userService;}

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String list(Model model) {
        if(userService.getAuthenticatedUser().getRole() != "ROLE_PRESSER")
        model.addAttribute("listOrders", pressSystemService.listAllOrdersByUser(userService.getAuthenticatedUser().getId()));
        else
            model.addAttribute("listOrders", pressSystemService.listAllOrders());
        return "orders";
    }

    @RequestMapping("order/{id}")
    public String showOrder(@PathVariable Integer id, Model model) {
        model.addAttribute("objOrder", pressSystemService.getOrderById(id));
        return "ordersshow";
    }

    @RequestMapping("order/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("objOrder", pressSystemService.getDataOrderById(id));
        model.addAttribute("objFruits",pressSystemService.listAllFruits());
        return "orderform";
    }

    @RequestMapping("order/new")
    public String newOrder(Model model) {
        model.addAttribute("objOrder", new OrderData());
        model.addAttribute("objFruits",pressSystemService.listAllFruits());
        return "orderform";
    }

    @RequestMapping(value = "order", method = RequestMethod.POST)
    public String saveOrder(@Valid OrderData order, Errors errors, Model model) {
        String message="";
        Order order2 = new Order();
        try{
            if(errors.hasErrors()){
                message = "Correct input errors please";
                throw new IllegalArgumentException();
            }
            if(!pressSystemService.checkEnoughInStock(order.getFruitId(),order.getAmount())){
                message ="Not enough juice";
                throw new IllegalArgumentException();
            }
            order.setUserId(userService.getAuthenticatedUser().getId());
            order2 = pressSystemService.processOrder(order);
        }
        catch(IllegalArgumentException e){

        }
        if(!message.equals("")){
            model.addAttribute("message",message);
            model.addAttribute("objFruits",pressSystemService.listAllFruits());
            model.addAttribute("objOrder",order);
            return "orderform";
        }
        return "redirect:/order/" + order2.getId();
    }

    @RequestMapping("order/delete/{id}")
    public String delete(@PathVariable Integer id) {
        pressSystemService.deleteOrder(id);
        return "redirect:/orders";
    }

    @RequestMapping("order/pressorders/{id}")
    public String listDetail(@PathVariable Integer id,Model model) {
        model.addAttribute("listOrders", pressSystemService.listPressOrderByOrder(id));//listAllPressOrders());
        return "ordersdetails";
    }

    @RequestMapping(value = {"order/rest"},method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody OrderData createOrder(@RequestBody OrderData orderData, HttpServletResponse response) throws BindException {
        pressSystemService.processOrder(orderData);
        return orderData;
    }

}
