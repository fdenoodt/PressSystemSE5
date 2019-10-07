package be.springPressOrder.controllers;

import be.springPressOrder.Data.ScheduleData;
import be.springPressOrder.services.PressSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.Errors;
import javax.validation.Valid;
import java.text.ParseException;


@Controller
@RequestMapping("/schedule")
public class ScheduleController {


    private PressSystemService pressSystemService;

    @Autowired
    public void setPressSystemService(PressSystemService pressSystemService){this.pressSystemService = pressSystemService;}

    @GetMapping
    public String scheduleCreateForm(Model model){
        ScheduleData newSchedule = new ScheduleData();
        prepareFrom(newSchedule, model);
        return "scheduleform";
    }

    private void prepareFrom(ScheduleData scheduleData,Model model){
        model.addAttribute("listMachines",pressSystemService.listAllMachines());
        model.addAttribute("objSchedule",scheduleData);
        model.addAttribute("listPressOrders", pressSystemService.listAllPressOrders());
    }

    @PostMapping
    public String saveSchedule(@Valid ScheduleData schedule,Errors errors,Model model){
        String message="";
        try{
            if(errors.hasErrors()){
                message = "Correct input errors please";
                throw new IllegalArgumentException();
            }

            message = pressSystemService.processSchedule(schedule);
            if(schedule.getId() != 0)
                return String.format("redirect:/machines/%d",schedule.getMachineId());
            schedule = new ScheduleData();
        }
        catch(IllegalArgumentException e){

        } catch (ParseException e) {

        }
        prepareFrom(schedule,model);
        model.addAttribute("message",message);
        return "scheduleform";
    }

        /*@RequestMapping(value = "/schedules", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("listSchedules",pressSystemService.listAllSchedules());
        return "schedules";
    }*/

    /*@RequestMapping(value = "/schedule/new")
    public String newSchedule(Model model){

    }*/



/*    @RequestMapping(value = "/machine/{idMachine}/newSchedule")
    public String newScheduleAfterChoosingMachine(@PathVariable Integer idMachine, Model model){

        ScheduleData newSchedule = new ScheduleData();
        newSchedule.machineId = idMachine;
        model.addAttribute("objSchedule",newSchedule);
        model.addAttribute("listPressOrders", pressSystemService.listAllPressOrders());
        //model.addAttribute("listMachines",pressSystemService.listAllMachines());
        return "scheduleform";
    }*/

}
