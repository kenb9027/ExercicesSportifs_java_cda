package fr.m2i.kenb9027.service.impl;

import fr.m2i.kenb9027.business.CentreSportif;
import fr.m2i.kenb9027.business.MachineDeSport;
import fr.m2i.kenb9027.dao.CentreSportifDao;
import fr.m2i.kenb9027.dao.MachineDeSportDao;
import fr.m2i.kenb9027.dao.impl.CentreSportifDaoImpl;
import fr.m2i.kenb9027.dao.impl.MachinedeSportDaoIml;
import fr.m2i.kenb9027.service.MachineDeSportService;

import java.sql.SQLException;
import java.util.ArrayList;

public class MachineDeSportServiceImpl implements MachineDeSportService {

    private MachineDeSportDao machineDeSportDao = new MachinedeSportDaoIml();
    private CentreSportifDao centreSportifDao = new CentreSportifDaoImpl();
    @Override
    public MachineDeSport addMachineDeSport(String name , CentreSportif centreSportif) {
        return null;
    }

    @Override
    public MachineDeSport getMachineDeSport(Long id) {

        try {
            return machineDeSportDao.findOneById(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public ArrayList<MachineDeSport> getAllMachineDeSport() {
        try {
            return machineDeSportDao.findAll();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<MachineDeSport> getAllMachineDeSportForOneCentreSportif(Long id) {
        try {
            return machineDeSportDao.findAllByCentreId(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
