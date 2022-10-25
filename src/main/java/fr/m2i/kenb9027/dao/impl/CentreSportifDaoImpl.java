package fr.m2i.kenb9027.dao.impl;

import fr.m2i.kenb9027.business.CentreSportif;
import fr.m2i.kenb9027.dao.CentreSportifDao;
import fr.m2i.kenb9027.dao.ConnectionBDD;
import fr.m2i.kenb9027.dao.Queries;

import java.sql.*;
import java.util.ArrayList;

public class CentreSportifDaoImpl implements CentreSportifDao {

    private Connection connection;

    public CentreSportifDaoImpl(){
        try {
            connection = ConnectionBDD.getConnection();
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException();
        }
    }

    @Override
    public CentreSportif create(CentreSportif centreSportif) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                Queries.CENTRE_CREATE,
                Statement.RETURN_GENERATED_KEYS
        );
        preparedStatement.setString(1, centreSportif.getName());
        preparedStatement.setString(2, centreSportif.getCity());

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next())
        {
            centreSportif.setId(resultSet.getLong(1));
        };

        return centreSportif;
    }

    @Override
    public CentreSportif findOneById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                Queries.CENTRE_FIND_ONE_BY_ID
        );

        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            CentreSportif centreSportif = new CentreSportif();
            centreSportif.setId(resultSet.getLong("id"));
            centreSportif.setName(resultSet.getString("name"));
            centreSportif.setCity(resultSet.getString("city"));
            return centreSportif;
        }
        return null;
    }

    @Override
    public ArrayList<CentreSportif> findAll() throws SQLException {
        ArrayList<CentreSportif> centresSportifs = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(Queries.CENTRE_FIND_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            CentreSportif centreSportif = new CentreSportif();
            centreSportif.setId(resultSet.getLong("id"));
            centreSportif.setName(resultSet.getString("name"));
            centreSportif.setCity(resultSet.getString("city"));
            centresSportifs.add(centreSportif);
        }
        return centresSportifs;
    }

}
