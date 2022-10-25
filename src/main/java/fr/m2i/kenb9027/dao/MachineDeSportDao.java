package fr.m2i.kenb9027.dao;

import fr.m2i.kenb9027.business.MachineDeSport;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MachineDeSportDao {

    MachineDeSport create(MachineDeSport machineDeSport) throws SQLException;
    MachineDeSport findOneById(Long id) throws SQLException;
    ArrayList<MachineDeSport> findAll() throws SQLException;
    ArrayList<MachineDeSport> findAllByCentreId(Long id) throws SQLException;

}
