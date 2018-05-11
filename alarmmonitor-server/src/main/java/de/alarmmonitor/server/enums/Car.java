package de.alarmmonitor.server.enums;

public enum Car {
    LF1612("LF-1612", 44),
    LF16TS("LF-1612", 45),
    RW("RW", 51),
    MTW("MTW", 19);

    final String shortcut;
    final int radioCall;

    Car(String shortcut, int radioCall) {
        this.shortcut = shortcut;
        this.radioCall = radioCall;
    }

    public String getShortcut() {
        return shortcut;
    }

    public int getRadioCall() {
        return radioCall;
    }
}
