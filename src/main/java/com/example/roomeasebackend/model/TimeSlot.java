package com.example.roomeasebackend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TimeSlot {
    MORNING("Morning"),
    AFTERNOON("Afternoon"),
    EVENING("Evening");

    private final String value;

    TimeSlot(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TimeSlot fromValue(String value) {
        for (TimeSlot timeSlot : TimeSlot.values()) {
            if (timeSlot.value.equalsIgnoreCase(value)) {
                return timeSlot;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}