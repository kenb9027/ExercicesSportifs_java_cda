package fr.m2i.kenb9027.dao.impl;

import fr.m2i.kenb9027.business.Exercice;
import fr.m2i.kenb9027.dao.*;

import java.sql.*;
import java.util.ArrayList;

public class ExerciceDaoImpl implements ExerciceDao {

    private Connection connection;
    private CentreSportifDao centreSportifDao = new CentreSportifDaoImpl();
    private MachineDeSportDao machineDeSportDao = new MachinedeSportDaoIml();

    public void MachinedeSportDaoIml(){
        try {
            connection = ConnectionBDD.getConnection();
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Exercice create(Exercice exercice) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                Queries.EXERCICE_CREATE,
                Statement.RETURN_GENERATED_KEYS
        );
        preparedStatement.setDate(1, (Date) exercice.getDate());
        preparedStatement.setTime(2, (Time) exercice.getTimeStart());
        preparedStatement.setTime(3, (Time) exercice.getTimeEnd());
        preparedStatement.setLong(4, exercice.getMachineDeSport().getId());

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next())
        {
            exercice.setId(resultSet.getLong(1));
        };

        return exercice;
    }

    @Override
    public Exercice findOneById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                Queries.EXERCICE_FIND_ONE_BY_ID
        );

        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            Exercice exercice = new Exercice();
            exercice.setId(resultSet.getLong("id"));
            exercice.setDate(resultSet.getDate("date"));
            exercice.setTimeStart(resultSet.getTime("timeStart"));
            exercice.setTimeEnd(resultSet.getTime("timeEnd"));
            exercice.setMachineDeSport(machineDeSportDao.findOneById(resultSet.getLong("machineDeSport")));

            return exercice;
        }
        return null;
    }

    @Override
    public ArrayList<Exercice> findAll() throws SQLException {
        ArrayList<Exercice> exercices = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(Queries.EXERCICE_FIND_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            Exercice exercice = new Exercice();
            exercice.setId(resultSet.getLong("id"));
            exercice.setDate(resultSet.getDate("date"));
            exercice.setTimeStart(resultSet.getTime("timeStart"));
            exercice.setTimeEnd(resultSet.getTime("timeEnd"));
            exercice.setMachineDeSport(machineDeSportDao.findOneById(resultSet.getLong("machineDeSport")));
            exercices.add(exercice);
        }
        return exercices;
    }

    @Override
    public Exercice update(Exercice exercice) throws SQLException {
        return null;
    }

    @Override
    public void deleteOneById(Long id) throws SQLException {

    }

    @Override
    public ArrayList<Exercice> sortByDate() throws SQLException {
        ArrayList<Exercice> exercices = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(Queries.EXERCICE_SORT_BY_DATE);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            Exercice exercice = new Exercice();
            exercice.setId(resultSet.getLong("id"));
            exercice.setDate(resultSet.getDate("date"));
            exercice.setTimeStart(resultSet.getTime("timeStart"));
            exercice.setTimeEnd(resultSet.getTime("timeEnd"));
            exercice.setMachineDeSport(machineDeSportDao.findOneById(resultSet.getLong("machineDeSport")));
            exercices.add(exercice);
        }
        return exercices;
    }
}
