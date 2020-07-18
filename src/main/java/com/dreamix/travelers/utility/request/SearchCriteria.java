package com.dreamix.travelers.utility.request;

import lombok.Data;

@Data
public class SearchCriteria {
    private String filterByUser;
    private String filterByCity;
    private String filterByCountry;
    private String sortBy;

    private String dateFrom;
    private String dateTo;

    private Integer page;
    private Integer size;

    public boolean isEmpty() {
        return !(filterByUser != null
                || filterByCity != null
                || filterByCountry != null
                || sortBy != null
                || dateFrom != null
                || dateTo != null
                || page != null
                || size != null);
    }
}
