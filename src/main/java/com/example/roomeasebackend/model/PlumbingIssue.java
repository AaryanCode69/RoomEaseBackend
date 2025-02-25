package com.example.roomeasebackend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum PlumbingIssue {
    Water_Cooler("Water Cooler"),
    Water_Filter("Water Filter"),
    Tap("Tap"),
    Geyser("Geyser"),
    Washrooms("Washrooms"),
    Toilets("Toilets");

    private final String displayName;

    PlumbingIssue(String displayName) {
        this.displayName = displayName;
    }

    @JsonCreator
    public static PlumbingIssue fromString(String value) {
        for (PlumbingIssue issue : PlumbingIssue.values()) {
            if (issue.displayName.equalsIgnoreCase(value) ||
                    issue.name().equalsIgnoreCase(value)) {
                return issue;
            }
        }
        throw new IllegalArgumentException("Unknown plumbing issue: " + value);
    }
}
