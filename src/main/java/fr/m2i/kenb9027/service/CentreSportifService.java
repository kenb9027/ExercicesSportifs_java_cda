package fr.m2i.kenb9027.service;

import fr.m2i.kenb9027.business.CentreSportif;

import java.util.ArrayList;

public interface CentreSportifService {

    CentreSportif addCentreSportif(String name, String city);

    CentreSportif getCentreSportif(Long id);

    ArrayList<CentreSportif> getAllCentresSportif();
}
