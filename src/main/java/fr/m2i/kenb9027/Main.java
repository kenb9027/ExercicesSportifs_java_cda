package fr.m2i.kenb9027;

import fr.m2i.kenb9027.business.CentreSportif;
import fr.m2i.kenb9027.business.MachineDeSport;
import fr.m2i.kenb9027.service.CentreSportifService;
import fr.m2i.kenb9027.service.ExerciceService;
import fr.m2i.kenb9027.service.MachineDeSportService;
import fr.m2i.kenb9027.service.impl.CentreSportifServiceImpl;
import fr.m2i.kenb9027.service.impl.ExerciceServiceImpl;
import fr.m2i.kenb9027.service.impl.MachineDeSportServiceImpl;

import java.sql.Date;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final CentreSportifService centreSportifService = new CentreSportifServiceImpl();
    private static final MachineDeSportService machineDeSportService = new MachineDeSportServiceImpl();
    private static final ExerciceService exerciceService = new ExerciceServiceImpl();

    public static void main(String[] args) {

        System.out.println("Hello there ...");
        Scanner sc1 = new Scanner(System.in);

        int choiceInt = 1;
        do {
            ArrayList<CentreSportif> centreSportifList = centreSportifService.getAllCentresSportif();
            ArrayList<MachineDeSport> machineDeSportList = machineDeSportService.getAllMachineDeSport();
            displayMenu();
            String choice = sc1.next();
            // on redemande tant que ce n'est pas un chiffre entre 1 et 8  TODO:make limit dynamic in loop
            while (true){
                try {
                    choiceInt = Integer.parseInt(choice);
                    if (choiceInt > 8 || choiceInt < 1){
                        System.err.println("Entrez un nombre entre 1 et 5 svp! ");
                        choice = sc1.next(); // clear scanner wrong input
                        continue; // continues to loop if exception is found
                    }
                    break;

                } catch (NumberFormatException e) {
                    //throw new RuntimeException(e);
                    System.err.println("Entrez un nombre svp! " + e.getMessage());
                    choice = sc1.next(); // clear scanner wrong input
                    continue; // continues to loop if exception is found
                }
            }

            switch (choiceInt){
                case 1:
                    displayCentresSportifs(centreSportifList);
                    System.out.println();
                    break;
                case 2:
                    displayMachinesForOneCentreSportif(centreSportifList);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Ajouter un exercice sur une machine");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Modifier un exercice existant");
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Trier les exercices par date");
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Supprimer un exercice (sans supprimer la machine !)");
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Au revoir ! ");
                    System.out.println();
                    break;
                default:
                    break;

            }

        }while (choiceInt != 7);
        System.out.println("FIN DU PROGRAMME.");

    }


    /**
     * Display Menu
     */
    public static void displayMenu() {
        System.out.println("MENU");
        System.out.println("1. Voir les Centres Sportifs enregistrés");
        System.out.println("2. Voir les machines présentes dans un centre séléctionné");
        System.out.println("3. Ajouter un exercice sur une machine");
        System.out.println("4. Modifier un exercice existant");
        System.out.println("5. Trier les exercices par date");
        System.out.println("6. Supprimer un exercice (sans supprimer la machine !)");
        System.out.println("7. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    /**
     * Display Centres Sportifs ( #1 )
     */
    public static void displayCentresSportifs(ArrayList<CentreSportif> centreSportifList) {

        System.out.println("Liste des Centres Sportifs : ");
        for (CentreSportif centre :
                centreSportifList ) {
            System.out.println(centre);
        }
    }

    /**
     * Display Machines for 1 Centre Sportif ( #2 )
     */
    public  static  void displayMachinesForOneCentreSportif(ArrayList<CentreSportif> centreSportifList){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisissez un Centre Sportif :");
        for (CentreSportif centre :
                centreSportifList ) {
            System.out.println(centre.getId() + " - " + centre);
        }
        System.out.println("Id:");
        Long id = scanner.nextLong();

        ArrayList<MachineDeSport> machines = machineDeSportService.getAllMachineDeSportForOneCentreSportif(id);
        System.out.println("Liste des Machines du "+ centreSportifService.getCentreSportif(id) +" :");
        for (MachineDeSport machine :
                machines ) {
            System.out.println(machine);
        }

    }

    public static void addExercice(ArrayList<CentreSportif> centreSportifList)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ajouter un exercice :");
        //choix du centre
        System.out.println("Choisissez un Centre Sportif :");
        for (CentreSportif centre :
                centreSportifList ) {
            System.out.println(centre.getId() + " - " + centre);
        }
        System.out.print("Numéro:");
        Long idCentre = scanner.nextLong();
        //choix de la machine
        ArrayList<MachineDeSport> machines = machineDeSportService.getAllMachineDeSportForOneCentreSportif(idCentre);
        System.out.println("Choisissez une machine :");
        for (MachineDeSport machine :
                machines ) {
            System.out.println(machine.getId() + " - " + machine);
        }
        System.out.print("Numéro:");
        Long idMachine = scanner.nextLong();

        //choix de la date format jj/mm/aaaa




    }
}