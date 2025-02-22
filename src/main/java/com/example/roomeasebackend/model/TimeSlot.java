package com.example.roomeasebackend.model;

public enum TimeSlot {
    MORNING("Morning"),
    AFTERNOON("Afternoon"),
    EVENING("Evening");

    private final String value;

    TimeSlot(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
