package fr.m2i.kenb9027.service.impl;

import fr.m2i.kenb9027.business.Exercice;
import fr.m2i.kenb9027.business.MachineDeSport;
import fr.m2i.kenb9027.dao.CentreSportifDao;
import fr.m2i.kenb9027.dao.ExerciceDao;
import fr.m2i.kenb9027.dao.MachineDeSportDao;
import fr.m2i.kenb9027.dao.impl.CentreSportifDaoImpl;
import fr.m2i.kenb9027.dao.impl.ExerciceDaoImpl;
import fr.m2i.kenb9027.dao.impl.MachinedeSportDaoIml;
import fr.m2i.kenb9027.service.ExerciceService;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class ExerciceServiceImpl implements ExerciceService {

    private CentreSportifDao centreSportifDao = new CentreSportifDaoImpl();
    private MachineDeSportDao machineDeSportDao = new MachinedeSportDaoIml();
    private ExerciceDao exerciceDao = new ExerciceDaoImpl();
    @Override
    public Exercice addExercice(
            Date date, Time timeStart, Time timeEnd, MachineDeSport machineDeSport
    ) {
        Exercice newExercice = new Exercice(
                date, timeStart, timeEnd, machineDeSport
        );
        try {
            return exerciceDao.create(newExercice);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return newExercice;
    }

    @Override
    public Exercice getOneExercice(Long id) {

        try {
            return exerciceDao.findOneById(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public ArrayList<Exercice> getAllExercice() {

        try {
            return exerciceDao.findAll();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Exercice> sortAllExerciceByDate() {

        try {
            return exerciceDao.sortByDate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteExercice(Long id) {

        try {
            return exerciceDao.deleteOneById(id);
        } catch (SQLException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        return false;
    }
}
