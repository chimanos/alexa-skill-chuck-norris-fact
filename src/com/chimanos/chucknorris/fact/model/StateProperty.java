package com.chimanos.chucknorris.fact.model;

public enum StateProperty {

    NAME("name"),
    ABBREVIATION("abbreviation"),
    CAPITAL("capital"),
    STATEHOOD_YEAR("statehood year"),
    STATEHOOD_ORDER("statehood order");

    private String value;

    public String getValue() {
        return value;
    }

    StateProperty(String value) {
        this.value = value;
    }

}