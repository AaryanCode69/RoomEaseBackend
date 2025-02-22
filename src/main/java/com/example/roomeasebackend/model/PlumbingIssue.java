package com.example.roomeasebackend.model;

public enum PlumbingIssue {
    Water_Cooler("Water Cooler"),
    Water_Filter("Water Heater"),
    Tap("Tap"),
    Geyser("Geyser"),
    Washrooms("Washrooms"),
    Toilets("Toilets");

    private final String displayName;

    PlumbingIssue(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
