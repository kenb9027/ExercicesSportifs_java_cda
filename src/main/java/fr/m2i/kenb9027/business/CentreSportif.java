package fr.m2i.kenb9027.business;

import java.util.ArrayList;

public class CentreSportif {

    private Long id;
    private String name;
    private String city;
    private ArrayList<MachineDeSport> machineDeSports;

    public CentreSportif()
    {
        this.machineDeSports = new ArrayList<>();
    }

    public CentreSportif(String name, String city) {
        super();
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Centre Sportif " + name + ", à " + city ;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<MachineDeSport> getMachineDeSports() {
        return machineDeSports;
    }

    public void setMachineDeSports(ArrayList<MachineDeSport> machineDeSports) {
        this.machineDeSports = machineDeSports;
    }
}
