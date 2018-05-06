package com.example.sqlitetesting.dataprovider;

/**
 * Created by Anonymous on 5/6/2018.
 */
public class ListDataProvider {

    private String titles, details;

    public ListDataProvider(String titles, String details) {
        this.titles = titles;
        this.details = details;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
