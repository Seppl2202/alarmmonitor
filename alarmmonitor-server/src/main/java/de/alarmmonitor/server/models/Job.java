package de.alarmmonitor.server.models;

import de.alarmmonitor.server.enums.Car;
import de.alarmmonitor.server.enums.JobType;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Job {
    private String description;
    private Date createDate;
    private JobType jobType;
    private List<Car> alarmedUnits;
    private String reporter;
    private String adress;
    private String uuid;
    boolean running;

    public Job(String description, Date createDate, JobType jobType, List<Car> alarmedUnits, String reporter, String adress) {
        this.description = description;
        this.createDate = createDate;
        this.jobType = jobType;
        this.alarmedUnits = alarmedUnits;
        this.reporter = reporter;
        this.adress = adress;
        generateJobId();
    }

    private void generateJobId() {
        this.uuid = UUID.randomUUID().toString();
        this.running = false;
    }

    @Override
    public String toString() {
        return this.jobType.getShortcut() + ": " + this.adress;
    }

    public String carsAsString() {
        StringBuilder b = new StringBuilder();
        for (Car c : alarmedUnits
                ) {
            b.append(c.getShortcut());
            b.append(" ");
        }
        return b.toString();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public List<Car> getAlarmedUnits() {
        return alarmedUnits;
    }

    public void setAlarmedUnits(List<Car> alarmedUnits) {
        this.alarmedUnits = alarmedUnits;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getUuid() {
        return uuid;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isRunning() {
        return running;
    }
}
