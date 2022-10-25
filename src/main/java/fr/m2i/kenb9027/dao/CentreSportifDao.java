package fr.m2i.kenb9027.dao;

import fr.m2i.kenb9027.business.CentreSportif;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CentreSportifDao {

    CentreSportif create(CentreSportif centreSportif) throws SQLException;
    CentreSportif findOneById(Long id) throws  SQLException;
    ArrayList<CentreSportif> findAll() throws SQLException;
}
