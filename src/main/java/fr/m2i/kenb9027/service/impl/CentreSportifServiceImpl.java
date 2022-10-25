package fr.m2i.kenb9027.service.impl;

import fr.m2i.kenb9027.business.CentreSportif;
import fr.m2i.kenb9027.dao.CentreSportifDao;
import fr.m2i.kenb9027.dao.impl.CentreSportifDaoImpl;
import fr.m2i.kenb9027.service.CentreSportifService;

import java.sql.SQLException;
import java.util.ArrayList;

public class CentreSportifServiceImpl implements CentreSportifService {

    private CentreSportifDao centreSportifDao = new CentreSportifDaoImpl();
    @Override
    public CentreSportif addCentreSportif(String name, String city) {
        return null;
    }

    @Override
    public CentreSportif getCentreSportif(Long id) {
        try {
            return centreSportifDao.findOneById(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<CentreSportif> getAllCentresSportif() {

        try {
            return centreSportifDao.findAll();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
