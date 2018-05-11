package de.alarmmonitor.server.controllers;

import de.alarmmonitor.server.models.Job;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private static List<Job> jobs = new ArrayList<>();

    public static boolean addJob(Job j) {
        jobs.add(j);
        return true;
    }

    public static List<Job> getJobs() {
        return jobs;
    }

    public static Job getByIndex(int index) {
        return jobs.get(index);
    }

    public static Job getByAdress(String adress) {
        for (Job j : jobs) {
            if (j.getAdress().equalsIgnoreCase(adress)) {
                return j;
            }
        }
        return null;
    }

    public static Job getByDescription(String description) {
        for (Job j : jobs
                ) {
            if (j.getDescription().equalsIgnoreCase(description)) {
                return j;
            }
        }
        return null;
    }

    public static Job getByUUID(String uuid) {
        for (Job j : jobs
                ) {
            if (j.getUuid().equalsIgnoreCase(uuid)) {
                return j;
            }
        }
        return null;
    }

    public static List<Job> getAllAlarmedJobs() {
        List<Job> alarmed = new ArrayList<>();
        for (Job j : jobs
                ) {
            if (j.isRunning()) {
                alarmed.add(j);
            }
        }
        return alarmed;
    }
}
