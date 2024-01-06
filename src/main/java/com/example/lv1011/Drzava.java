package com.example.lv1011;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Drzava implements Serializable {

    private SimpleIntegerProperty drzavaID;
    private SimpleStringProperty naziv;
    private SimpleIntegerProperty gradID;

    public Drzava(SimpleIntegerProperty drzavaID, SimpleStringProperty naziv, SimpleIntegerProperty gradID) {
        this.drzavaID = drzavaID;
        this.naziv = naziv;
        this.gradID = gradID;
    }

    public Drzava(Integer drzavaID, String naziv, Integer gradID) {
        this.drzavaID = new SimpleIntegerProperty(drzavaID);
        this.naziv = new SimpleStringProperty(naziv);
        this.gradID = new SimpleIntegerProperty(gradID);
    }

    public void setDrzavaID(int drzavaID) {
        this.drzavaID.set(drzavaID);
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }

    public void setGradID(int gradID) {
        this.gradID.set(gradID);
    }

    public int getDrzavaID() {
        return drzavaID.get();
    }

    public SimpleIntegerProperty drzavaIDProperty() {
        return drzavaID;
    }

    public String getNaziv() {
        return naziv.get();
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    public int getGradID() {
        return gradID.get();
    }

    public SimpleIntegerProperty gradIDProperty() {
        return gradID;
    }

    @Override
    public String toString() {
        return naziv.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drzava)) return false;
        Drzava drzava = (Drzava) o;
        return Objects.equals(getDrzavaID(), drzava.getDrzavaID()) && Objects.equals(getNaziv(), drzava.getNaziv()) && Objects.equals(getGradID(), drzava.getGradID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDrzavaID(), getNaziv(), getGradID());
    }

}