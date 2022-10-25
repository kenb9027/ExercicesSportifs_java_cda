package fr.m2i.kenb9027.service.impl;

import fr.m2i.kenb9027.business.Exercice;
import fr.m2i.kenb9027.business.MachineDeSport;
import fr.m2i.kenb9027.service.ExerciceService;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class ExerciceServiceImpl implements ExerciceService {
    @Override
    public Exercice addExercice(Date date, Time timeStart, Time dateEnd, MachineDeSport machineDeSport) {
        return null;
    }

    @Override
    public Exercice getOneExercice(Long id) {
        return null;
    }

    @Override
    public ArrayList<Exercice> getAllExercice() {
        return null;
    }

    @Override
    public ArrayList<Exercice> sortAllExerciceByDate() {
        return null;
    }
}
