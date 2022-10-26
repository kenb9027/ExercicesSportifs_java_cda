package fr.m2i.kenb9027.dao.impl;

import fr.m2i.kenb9027.business.CentreSportif;
import fr.m2i.kenb9027.business.MachineDeSport;
import fr.m2i.kenb9027.dao.CentreSportifDao;
import fr.m2i.kenb9027.dao.ConnectionBDD;
import fr.m2i.kenb9027.dao.MachineDeSportDao;
import fr.m2i.kenb9027.dao.Queries;

import java.sql.*;
import java.util.ArrayList;

public class MachinedeSportDaoIml implements MachineDeSportDao {

    private Connection connection;
    private CentreSportifDao centreSportifDao = new CentreSportifDaoImpl();

    public MachinedeSportDaoIml(){
        try {
            connection = ConnectionBDD.getConnection();
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException();
        }
    }

    @Override
    public MachineDeSport create(MachineDeSport machineDeSport) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                Queries.MACHINE_CREATE,
                Statement.RETURN_GENERATED_KEYS
        );
        preparedStatement.setString(1, machineDeSport.getName());
        preparedStatement.setLong(2, machineDeSport.getCentreSportif().getId());
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next())
        {
            machineDeSport.setId(resultSet.getLong(1));
        };

        return machineDeSport;
    }

    @Override
    public MachineDeSport findOneById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                Queries.MACHINE_FIND_ONE_BY_ID
        );

        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            MachineDeSport machineDeSport = new MachineDeSport();
            machineDeSport.setId(resultSet.getLong("id"));
            machineDeSport.setName(resultSet.getString("name"));
            machineDeSport.setCentreSportif(centreSportifDao.findOneById(resultSet.getLong("centreSportifId")));
            return machineDeSport;
        }
        return null;
    }

    @Override
    public ArrayList<MachineDeSport> findAll() throws SQLException {
        ArrayList<MachineDeSport> machines = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(Queries.MACHINE_FIND_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            MachineDeSport machineDeSport = new MachineDeSport();
            machineDeSport.setId(resultSet.getLong("id"));
            machineDeSport.setName(resultSet.getString("name"));
            machineDeSport.setCentreSportif(centreSportifDao.findOneById(resultSet.getLong("centreSportifId")));
            machines.add(machineDeSport);
        }
        return machines;
    }

    @Override
    public ArrayList<MachineDeSport> findAllByCentreId(Long id) throws SQLException {
        ArrayList<MachineDeSport> machines = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                Queries.MACHINE_FIND_ALL_BY_CENTRE_ID
        );

        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            MachineDeSport machineDeSport = new MachineDeSport();
            machineDeSport.setId(resultSet.getLong("id"));
            machineDeSport.setName(resultSet.getString("name"));
            machineDeSport.setCentreSportif(centreSportifDao.findOneById(resultSet.getLong("centreSportifId")));
            machines.add(machineDeSport);
        }
        return machines;
    }
}
