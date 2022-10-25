package fr.m2i.kenb9027.dao;

import fr.m2i.kenb9027.business.Exercice;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExerciceDao {

    Exercice create(Exercice exercice) throws SQLException;
    Exercice findOneById(Long id) throws SQLException;
    ArrayList<Exercice> findAll() throws SQLException;
    Exercice update(Exercice exercice) throws SQLException;
    void deleteOneById(Long id) throws SQLException;
    ArrayList<Exercice> sortByDate() throws SQLException;
}
