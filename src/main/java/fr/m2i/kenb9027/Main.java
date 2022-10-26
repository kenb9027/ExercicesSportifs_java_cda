package fr.m2i.kenb9027;

import fr.m2i.kenb9027.business.CentreSportif;
import fr.m2i.kenb9027.business.Exercice;
import fr.m2i.kenb9027.business.MachineDeSport;
import fr.m2i.kenb9027.service.CentreSportifService;
import fr.m2i.kenb9027.service.ExerciceService;
import fr.m2i.kenb9027.service.MachineDeSportService;
import fr.m2i.kenb9027.service.impl.CentreSportifServiceImpl;
import fr.m2i.kenb9027.service.impl.ExerciceServiceImpl;
import fr.m2i.kenb9027.service.impl.MachineDeSportServiceImpl;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Main {

    private static final CentreSportifService centreSportifService = new CentreSportifServiceImpl();
    private static final MachineDeSportService machineDeSportService = new MachineDeSportServiceImpl();
    private static final ExerciceService exerciceService = new ExerciceServiceImpl();

    public static void main(String[] args) throws ParseException {

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
                    addExercice(centreSportifList);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Modifier un exercice existant");
                    System.out.println();
                    break;
                case 5:
                    sortExercicesByDate();
                    System.out.println();
                    break;
                case 6:
                    deleteExercice();
                    System.out.println();
                    break;
                case 7:
                    System.out.println();
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

        //choix du centre
        System.out.println("Choisissez un Centre Sportif :");
        Long idCentre = 0L;
        ArrayList<Long> idList = new ArrayList<>();
        for (CentreSportif centre :
                centreSportifList ) {
            idList.add(centre.getId());
        }
        boolean centreBool = idList.contains(idCentre);
        while (!centreBool){
            for (CentreSportif centre :
                    centreSportifList ) {
                System.out.println(centre.getId() + " - " + centre);
            }
            System.out.print("Numéro:");
            idCentre = scanner.nextLong();
            centreBool = idList.contains(idCentre);
            if (!centreBool){
                System.out.println("Numéro inexistant.");
            }
        }

        //affichage desmachines
        ArrayList<MachineDeSport> machines = machineDeSportService.getAllMachineDeSportForOneCentreSportif(idCentre);
        System.out.println("Liste des Machines du "+ centreSportifService.getCentreSportif(idCentre) +" :");
        for (MachineDeSport machine :
                machines ) {
            System.out.println(machine);
        }

    }

    /**
     *  Add an exercice
     * @param centreSportifList
     */
    public static void addExercice(ArrayList<CentreSportif> centreSportifList) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ajouter un exercice :");
        //choix du centre
        Long idCentre = 0L;
        ArrayList<Long> idList = new ArrayList<>();
        for (CentreSportif centre :
                centreSportifList ) {
            idList.add(centre.getId());
        }
        boolean centreBool = idList.contains(idCentre);
        while (!centreBool){
            System.out.println("Choisissez un Centre Sportif :");
            for (CentreSportif centre :
                    centreSportifList ) {
                System.out.println(centre.getId() + " - " + centre);
            }
            System.out.print("Numéro:");
            idCentre = scanner.nextLong();
            centreBool = idList.contains(idCentre);
            if (!centreBool){
                System.out.println("Numéro inexistant.");
            }
        }
        System.out.println(centreSportifService.getCentreSportif(idCentre));


        //choix de la machine
        Long idMachine = 0L;
        ArrayList<Long> idMachineList = new ArrayList<>();
        ArrayList<MachineDeSport> machines = machineDeSportService.getAllMachineDeSportForOneCentreSportif(idCentre);
        for (MachineDeSport machine :
                machines ) {
            idMachineList.add(machine.getId());
        }
        boolean machineBool = idMachineList.contains(idMachine);
        while (!machineBool){
            System.out.println("Choisissez une machine :");
            for (MachineDeSport machine :
                    machines ) {
                System.out.println(machine.getId() + " - " + machine);
            }
            System.out.print("Numéro:");
            idMachine = scanner.nextLong();
            machineBool = idMachineList.contains(idMachine);
            if (!machineBool){
                System.out.println("Numéro inexistant.");
            }
        }
        System.out.println(machineDeSportService.getMachineDeSport(idMachine));


        //choix de la date format dd-MM-yyyy
        Date date = askForDate();
        System.out.println("Date : " + date);

        // choix de timeStart ( format HH:mm )
        Time timeStart = askFortime("début");
        System.out.println("Départ : " + timeStart);


        // choix de timeEnd ( format HH:mm )
        // heure supérieur à l'heure de départ
        Time timeEnd = timeStart;
        int compareTime = timeEnd.compareTo(timeStart);
        boolean comparebool = false;
        while (!comparebool){
            timeEnd = askFortime("fin");
            compareTime = timeEnd.compareTo(timeStart);
            if (compareTime  > 0){
                comparebool = true;
                break;
            }
            System.out.println("Horaire de fin d'exercice invalide.");
        }
        System.out.println("Arrêt : " + timeEnd);

        Exercice addedExe = exerciceService.addExercice(date, timeStart, timeEnd, machineDeSportService.getMachineDeSport(idMachine));
        System.out.println("Exercice ajouté !");
//        System.out.println(addedExe);
    }

    /**
     * Ask for a date
     * @return
     * @throws ParseException
     */
    public static Date askForDate() throws ParseException {
        Scanner dateScanner = new Scanner(System.in);
        java.util.Date day = new java.util.Date();

        boolean dateOk = false;
        while (!dateOk){
            System.out.println("Choississez le jour de votre exercice : ( au format dd-MM-yyyy)");
            String dateString = dateScanner.next();

            if (dateString.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})")) {
                try {

                    day = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);

                    dateOk = true;
                    break;

                } catch (Exception e) {
                    // throw new RuntimeException(e);
                    System.out.println(dateString);
                    System.out.println("Date invalide.");
                }
            }
            System.out.println("Date invalide.");
        }
        Date date = new Date( day.getYear() , day.getMonth(), day.getDate() );
        return date;
    }

    /**
     * Ask for a time
     * @param string "début" ou "fin"
     * @return
     */
    public static Time askFortime(String string)
    {
        Scanner timeScanner = new Scanner(System.in);
        Time time = new Time(0);
        String localTimeString = LocalTime.of(0, 0).format(
                // using a desired pattern
                DateTimeFormatter.ofPattern("HH:mm"));

        boolean timeOk = false;
        while (!timeOk){
            System.out.println("Choississez l'heure de "+string+" de l'exercice : ( au format HH:mm)");
            String timeString = timeScanner.next();

            if (timeString.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")) {
                try {
                    String[] timeStringList = timeString.split(":");
                    localTimeString = LocalTime.of( Integer.parseInt(timeStringList[0]) , Integer.parseInt(timeStringList[1])).format(
                            // using a desired pattern
                            DateTimeFormatter.ofPattern("HH:mm"));
                    time = new Time(Integer.parseInt(timeStringList[0]) , Integer.parseInt(timeStringList[1]), 0);
                    timeOk = true;
                    break;

                } catch (Exception e) {
                    // throw new RuntimeException(e);
                    System.out.println(timeString);
                    System.out.println("Horaire invalide.");
                }
            }
            System.out.println("Horaire invalide.");
        }

        return time;
    }

    /**
     * Sort exercices by date desc.
     */
    public static void sortExercicesByDate(){
        ArrayList<Exercice> exercicesList = exerciceService.sortAllExerciceByDate();
        System.out.println("Liste des exercices triés par Date (du plus récent au plus ancien) :");
        for (Exercice exercice :
                exercicesList) {
            System.out.println(exercice);
        };
    }

    /**
     * Delete an exercice
     */
    public static void deleteExercice()
    {
        Scanner delScanner = new Scanner(System.in);
        ArrayList<Exercice> exercicesList = exerciceService.getAllExercice();
        System.out.println("Supprimer un exercice");
        Long idExercice = 0L;
        ArrayList<Long> idList = new ArrayList<>();
        for (Exercice exercice :
                exercicesList ) {
            idList.add(exercice.getId());
        }
        boolean exeBool = idList.contains(idExercice);
        while (!exeBool){
            System.out.println("Choisissez un exercice à supprimer :");
            for (Exercice exercice :
                    exercicesList ) {
                System.out.println(exercice.getId() + " - " + exercice);
            }
            System.out.print("Numéro:");
            idExercice = delScanner.nextLong();
            exeBool = idList.contains(idExercice);
            if (!exeBool){
                System.out.println("Numéro inexistant.");
            }
        }

        boolean bool = exerciceService.deleteExercice(idExercice);
        if (!bool){
            System.out.print("Exercice #"+ idExercice +" supprimé !");
        }
        else {
            System.out.print("Erreur : Exercice #"+ idExercice +" non supprimé !");
        }


    }
}