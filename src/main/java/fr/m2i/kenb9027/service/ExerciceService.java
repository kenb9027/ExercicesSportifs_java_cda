package fr.m2i.kenb9027.service;

import fr.m2i.kenb9027.business.Exercice;
import fr.m2i.kenb9027.business.MachineDeSport;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public interface ExerciceService {

    Exercice addExercice(Date date , Time timeStart , Time timeEnd, MachineDeSport machineDeSport);

    Exercice getOneExercice(Long id);

    ArrayList<Exercice> getAllExercice();

    ArrayList<Exercice> sortAllExerciceByDate();

    boolean deleteExercice(Long id);

    Exercice updateExercice(Exercice exercice);
}
