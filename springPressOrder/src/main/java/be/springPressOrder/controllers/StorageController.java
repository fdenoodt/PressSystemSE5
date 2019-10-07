package be.springPressOrder.controllers;

import be.springPressOrder.domain.Storage;
import be.springPressOrder.services.PressSystemService;
import be.springPressOrder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping(path = "/storage")
public class StorageController {
    private PressSystemService pressSystemService;
    private UserService userService;

    @Autowired
    private void setPressSystemService(PressSystemService pressSystemService) {
        this.pressSystemService = pressSystemService;
    }

    @Autowired
    private void setUserService(UserService userService){this.userService = userService;}

    @GetMapping(path = "/json")
    public @ResponseBody
    List<Storage> getStorage(){
        return (List<Storage>) pressSystemService.listAllStorages();
    }

    @GetMapping
    public String GetStorage(Model model)
    {
        model.addAttribute("listStorage",pressSystemService.listAllStorages());
        String role;
        if(userService.getAuthenticatedUser() != null)
            role = userService.getAuthenticatedUser().getRole();
        else
            role = "ROLE_USER";
        model.addAttribute("role",role);
        return "storage";
    }

    @GetMapping(path = "/predict/{id}")
    public String predict(@PathVariable int id,Model model){
        try{
            model.addAttribute("objPrediction",pressSystemService.predictFruitAmount(id));
            model.addAttribute("objFruit",pressSystemService.predictFruitAmount(id).getPredictedFruit());
        }
        catch (Exception e){

        }
        return "showprediction";
    }

}
