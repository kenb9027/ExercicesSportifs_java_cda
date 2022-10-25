package fr.m2i.kenb9027.business;

import java.util.ArrayList;

public class MachineDeSport {

    private Long id;
    private String name;
    private CentreSportif centreSportif ;

    public MachineDeSport(String name, CentreSportif centreSportif) {
        this.name = name;
        this.centreSportif = centreSportif;
    }

    public MachineDeSport() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CentreSportif getCentreSportif() {
        return centreSportif;
    }

    public void setCentreSportif(CentreSportif centreSportif) {
        this.centreSportif = centreSportif;
    }
}
