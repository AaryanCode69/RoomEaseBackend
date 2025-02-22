package com.example.roomeasebackend.model;

public enum ElectricalIssue {
    LIGHTS("Lights"),
    SOCKETS("Sockets"),
    FAN("Fan"),
    SWITCHES("Switches"),
    WIRES("Wires"),
    OTHER("Other");

    private final String value;

    ElectricalIssue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
