package com.example.roomeasebackend.model;

import lombok.Getter;

@Getter
public enum HostelType {
    LADIES("Ladies"),
    MENS("Mens");

    private final String value;

    HostelType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}