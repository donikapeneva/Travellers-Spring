package com.dreamix.travelers.utility;

public enum SortByValidSpecifications {
    ADVENTURE_NAME("AdventureName"),
    DATE("Date"),
    DATE_DESC("DateDesc");

    private String value;

    private SortByValidSpecifications(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
