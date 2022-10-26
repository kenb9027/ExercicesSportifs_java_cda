package fr.m2i.kenb9027.business;

import java.sql.Time;
import java.sql.Date;

public class Exercice {

    private Long id;
    private Date date;
    private Time timeStart;
    private Time timeEnd;

    private MachineDeSport machineDeSport;

    public Exercice(Date date, Time timeStart, Time timeEnd, MachineDeSport machineDeSport) {
        this.date = date;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.machineDeSport = machineDeSport;
    }

    public Exercice() {

    }

    @Override
    public String toString() {
        return "Exercice{" +
                "id=" + id +
                "date=" + date +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", machineDeSport=" + machineDeSport +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }


    public MachineDeSport getMachineDeSport() {
        return machineDeSport;
    }

    public void setMachineDeSport(MachineDeSport machineDeSport) {
        this.machineDeSport = machineDeSport;
    }
}
