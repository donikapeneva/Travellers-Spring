package com.dreamix.travelers.utility.request;

public enum FilterByRules {
    TIME("TIME"),
    CITY("CITY"),
    COUNTY("COUNTY"),
    USER_ID("USERID");


    private final String filertBy;

    private FilterByRules(String filertBy) {
        this.filertBy = filertBy;
    }

    public String getValue() {
        return this.filertBy;
    }

    public static FilterByRules getValueByFilter(String filter) {
        return CITY;
    }
}
