package be.springPressOrder.controllers;


import be.springPressOrder.Data.ScheduleData;
import be.springPressOrder.services.PressSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/machines")
public class MachineController {

    private PressSystemService pressSystemService;

    @Autowired
    private void setPressSystemService(PressSystemService pressSystemService){this.pressSystemService = pressSystemService;}

    @GetMapping
    public String listMachines(Model model) {
        model.addAttribute("listMachines",pressSystemService.listAllMachines());
        return "machines";
    }

    private void prepareScheduleModel(Model model, int id){
        model.addAttribute("objMachine",pressSystemService.getMachineById(id));
        model.addAttribute("listSchedules",pressSystemService.getSchedulesByMachine(pressSystemService.getMachineById(id)));
    }

    @GetMapping(path = "/{id}")
    public String showSchedules(@PathVariable Integer id, Model model) {
        prepareScheduleModel(model, id);
        return "machineshow";
    }

    @GetMapping(path = "/check")
    public String checkMachine(Model model){
        pressSystemService.checkMachinesStatus();
        return "redirect:/machines";
    }

    @GetMapping(path= "/{id}/delete/{idSchedule}")
    public String deleteSchedule(@PathVariable Integer id,@PathVariable Integer idSchedule, Model model)
    {
        pressSystemService.deleteSchedule(idSchedule);
        prepareScheduleModel(model,id);
        return String.format("redirect:/machines/%d",id);
    }

    @GetMapping(value = "/{id}/edit/{idSchedule}")
    public String editSchedule(@PathVariable Integer id,@PathVariable Integer idSchedule, Model model)
    {
        ScheduleData scheduleData = pressSystemService.prepareScheduleData(idSchedule);
        model.addAttribute("listMachines",pressSystemService.listAllMachines());
        model.addAttribute("objSchedule",scheduleData);
        model.addAttribute("listPressOrders", pressSystemService.listAllPressOrders());
        return "scheduleform";
    }
    
    @RequestMapping("machines/changeStatus/{id}")
    public String changeStatus(@PathVariable Integer id, Model model) {
        pressSystemService.ChangeMachineStatus(id);
        model.addAttribute("listMachines", pressSystemService.listAllMachines());
        return "machines";
    }



}
