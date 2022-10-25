package fr.m2i.kenb9027.service;

import fr.m2i.kenb9027.business.CentreSportif;
import fr.m2i.kenb9027.business.MachineDeSport;

import java.util.ArrayList;

public interface MachineDeSportService {

    MachineDeSport addMachineDeSport(String name , CentreSportif centreSportif);

    MachineDeSport getMachineDeSport(Long id);

    ArrayList<MachineDeSport> getAllMachineDeSport();

    ArrayList<MachineDeSport> getAllMachineDeSportForOneCentreSportif(Long id);
}
