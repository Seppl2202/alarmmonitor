package de.alarmmonitor.server.controllers;

import de.alarmmonitor.server.enums.Car;
import de.alarmmonitor.server.enums.JobType;
import de.alarmmonitor.server.models.Job;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AddJobController {

    @CrossOrigin
    @RequestMapping(value = "/rest/addJob/description/{description}/createDate/{createDate}/jobType/{jobType}/alarmedUnits/{alarmedUnits}/" +
            "reporter/{reporter}/adress/{adress}", method = RequestMethod.POST)
    public void addJob(@PathVariable String description,
                       @PathVariable String createDate,
                       @PathVariable String jobType,
                       @PathVariable String[] alarmedUnits,
                       @PathVariable String reporter,
                       @PathVariable String adress) {

        Date d = createDateFromString(createDate);
        JobType submittedJobType = mapJobType(jobType);
        List<Car> submittedAlarmedUnits = mapAlarmedUnits(alarmedUnits);

        Job j = new Job(
                description,
                d,
                submittedJobType,
                submittedAlarmedUnits,
                reporter,
                adress
        );
        MainController.addJob(j);
    }

    @CrossOrigin
    @RequestMapping(value = "/rest/updateStatus/uuid/{uuid}/newStatus/{status}", method = RequestMethod.PATCH)
    public void updateJobStatus(@PathVariable String uuid, @PathVariable boolean status) {
        for (Job j : MainController.getJobs()
                ) {
            if (j.getUuid().toString().equalsIgnoreCase(uuid.toString())) {
                j.setRunning(status);
            }
        }
    }

    private List<Car> mapAlarmedUnits(String[] alarmedUnits) {
        List<Car> alarmedUnitsList = new ArrayList<>();
        for (String s : alarmedUnits
                ) {
            alarmedUnitsList.add(Car.valueOf(s));
        }
        return alarmedUnitsList;
    }

    private JobType mapJobType(String submittedJobType) {
        return JobType.valueOf(submittedJobType);
    }

    private Date createDateFromString(String dateToCrreate) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = formatter.parse(dateToCrreate);
            return d;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

}
