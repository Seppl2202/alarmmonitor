package de.alarmmonitor.server.controllers;

import de.alarmmonitor.server.models.Job;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GetJobController {

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/rest/getJobs", method = RequestMethod.GET)
    public List<Job> getJobs() {
        return MainController.getJobs();
    }

    @RequestMapping(value = "/rest/getJob/index/{index}", method = RequestMethod.GET)
    public Job getByIndex(@PathVariable int index) {
        return MainController.getByIndex(index);
    }

    @RequestMapping(value = "/rest/getJob/adress/{adress}", method = RequestMethod.GET)
    public Job getByAdress(@PathVariable String adress) {
        return MainController.getByAdress(adress);
    }

    @RequestMapping(value = "/rest/getJob/uuid/{uuid}", method = RequestMethod.GET)
    public Job getByUUID(@PathVariable String uuid) {
        return MainController.getByUUID(uuid);
    }

    @RequestMapping(value="/rest/getJob/getAllAlarmed", method = RequestMethod.GET)
    public List<Job> getAllAlarmedJobs() {
        return MainController.getAllAlarmedJobs();
    }
}
