package com.dreamix.travelers.utility.request;

public enum SortByRules {
    TIME("TIME"),
    PLACE("PLACE");

    private final String sortBy;

    private SortByRules(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getValue() {
        return this.sortBy;
    }
}
