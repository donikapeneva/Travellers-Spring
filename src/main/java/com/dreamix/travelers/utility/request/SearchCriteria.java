package com.dreamix.travelers.utility.request;

public class SearchCriteria {
    private String sortBy;
    private String sortById;
    private String filterBy;
    private Integer filterById;
    private String groupBy;
    private String dateFrom;
    private String dateTo;
    private Integer page;
    private Integer size;

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortById() {
        return sortById;
    }

    public void setSortById(String sortById) {
        this.sortById = sortById;
    }

    public String getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(String filterBy) {
        this.filterBy = filterBy;
    }

    public Integer getFilterById() {
        return filterById;
    }

    public void setFilterById(String filterById) {
        Integer intValue = null;
        try {
            intValue = Integer.parseInt(filterById);
        } catch (NumberFormatException e){
            System.out.println("OOOPS! filterById cannot be converted to int");
        }
        this.filterById = intValue;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
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
        return "SearchDTO{" +
                "sortBy='" + sortBy + '\'' +
                ", sortById='" + sortById + '\'' +
                ", filterBy='" + filterBy + '\'' +
                ", filterById='" + filterById + '\'' +
                ", groupBy='" + groupBy + '\'' +
                ", dateFrom='" + dateFrom + '\'' +
                ", dateTo='" + dateTo + '\'' +
                ", page=" + page +
                ", size=" + size +
                '}';
    }

    public boolean isEmpty() {
        return !(sortBy != null
                || sortById != null
                || filterBy != null
                || filterById != null
                || groupBy != null
                || dateFrom != null
                || dateTo != null
                || page != null
                ||  size != null);
    }
}
