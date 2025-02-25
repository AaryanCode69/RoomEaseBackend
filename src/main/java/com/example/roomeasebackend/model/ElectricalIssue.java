package com.example.roomeasebackend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ElectricalIssue {
    OTHER("Other"),
    SWITCH("Switch"),
    FAN("Fan"),
    LIGHT("Light"),
    WIRING("Wiring"),
    SOCKET("Socket");

    private final String value;

    ElectricalIssue(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ElectricalIssue fromValue(String value) {
        for (ElectricalIssue issue : ElectricalIssue.values()) {
            if (issue.value.equalsIgnoreCase(value)) {
                return issue;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}