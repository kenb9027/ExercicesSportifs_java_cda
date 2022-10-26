package fr.m2i.kenb9027.dao;

public class Queries {

    //CENTRE SPORTIFS
    public static final String CENTRE_CREATE = "INSERT INTO centreSportif (name, city) VALUES (?, ?)";
    public static final String CENTRE_FIND_ONE_BY_ID = "SELECT * FROM centreSportif WHERE id= ?";
    public static final String CENTRE_FIND_ALL = "SELECT * FROM centreSportif";


    //MACHINES
    public static final String MACHINE_CREATE = "INSERT INTO machineDeSport (name, centreSportifId) VALUES (?, ?)";
    public static final String MACHINE_FIND_ONE_BY_ID = "SELECT * FROM machineDeSport WHERE id= ?";
    public static final String MACHINE_FIND_ALL = "SELECT * FROM machineDeSport";
    public static final String MACHINE_FIND_ALL_BY_CENTRE_ID = "SELECT * FROM machineDeSport WHERE centreSportifId= ?";


    //EXERCICES
    public static final String EXERCICE_CREATE = "INSERT INTO exercice (date, timeStart, timeEnd, machine) VALUES (?, ?, ?, ?)";
    public static final String EXERCICE_FIND_ONE_BY_ID = "SELECT * FROM exercice WHERE id= ?";
    public static final String EXERCICE_FIND_ALL = "SELECT * FROM exercice";
    public static final String EXERCICE_UPDATE = "UPDATE `exercice` SET `date`= ? ,`timeStart`= ? ,`timeEnd`= ? ,`machine` = ? WHERE id= ?";
    public static final String EXERCICE_DELETE_ONE_BY_ID = "DELETE FROM exercice WHERE id= ?";
    public static final String EXERCICE_SORT_BY_DATE = "SELECT * FROM exercice ORDER BY date DESC";

}
