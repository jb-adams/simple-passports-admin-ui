package org.ga4gh.passports.refimpl.admin.model;

public class Broker implements PassportModel {

    private String name;

    public Broker() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
