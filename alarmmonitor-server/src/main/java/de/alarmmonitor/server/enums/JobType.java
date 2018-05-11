package de.alarmmonitor.server.enums;

public enum JobType {
    FEUER("B", "FEUER"),
    TECHNISCHE_HILFE("TH", "Technische Hilfe"),
    SONSTIGE("S", "Sonstiges");

    final String shortcut;
    final String description;

    JobType(String shortcut, String description) {
        this.shortcut = shortcut;
        this.description = description;
    }

    public String getShortcut() {
        return shortcut;
    }

    public String getDescription() {
        return description;
    }
}
