package com.dreamix.travelers.utility.request;


public class SearchCriteria {
    private String filterByUser;
    private String filterByCity;
    private String filterByCountry;
    private String sortByUser;
    private String sortByCity;
    private String sortByCountry;
    private String sortByDate;

    private String dateFrom;
    private String dateTo;

    private Integer page;
    private Integer size;

    public String getFilterByUser() {
        return filterByUser;
    }

    public void setFilterByUser(String filterByUser) {
        this.filterByUser = filterByUser;
    }

    public String getFilterByCity() {
        return filterByCity;
    }

    public void setFilterByCity(String filterByCity) {
        this.filterByCity = filterByCity;
    }

    public String getFilterByCountry() {
        return filterByCountry;
    }

    public void setFilterByCountry(String filterByCountry) {
        this.filterByCountry = filterByCountry;
    }

    public String getSortByUser() {
        return sortByUser;
    }

    public void setSortByUser(String sortByUser) {
        this.sortByUser = sortByUser;
    }

    public String getSortByCity() {
        return sortByCity;
    }

    public void setSortByCity(String sortByCity) {
        this.sortByCity = sortByCity;
    }

    public String getSortByCountry() {
        return sortByCountry;
    }

    public void setSortByCountry(String sortByCountry) {
        this.sortByCountry = sortByCountry;
    }

    public String getSortByDate() {
        return sortByDate;
    }

    public void setSortByDate(String sortByDate) {
        this.sortByDate = sortByDate;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "filterByUser='" + filterByUser + '\'' +
                ", filterByCity='" + filterByCity + '\'' +
                ", filterByCountry='" + filterByCountry + '\'' +
                ", sortByUser='" + sortByUser + '\'' +
                ", sortByCity='" + sortByCity + '\'' +
                ", sortByCountry='" + sortByCountry + '\'' +
                ", sortByDate='" + sortByDate + '\'' +
                ", dateFrom='" + dateFrom + '\'' +
                ", dateTo='" + dateTo + '\'' +
                ", page=" + page +
                ", size=" + size +
                '}';
    }

    public boolean isEmpty() {
        return !(filterByUser != null
                || filterByCity != null
                || filterByCountry != null
                || sortByUser != null
                || sortByCity != null
                || sortByCountry != null
                || sortByDate != null
                || dateFrom != null
                || dateTo != null
                || page != null
                || size != null);
    }

}
