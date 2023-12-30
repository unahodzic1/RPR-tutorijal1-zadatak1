package com.example.lv1011;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.io.Serializable;
import java.util.Objects;

public class Grad implements Serializable {

    private SimpleIntegerProperty gradID;
    private SimpleStringProperty naziv;
    private SimpleIntegerProperty brojStanovnika;
    private SimpleIntegerProperty drzavaID;

    public Grad(SimpleIntegerProperty gradID, SimpleStringProperty naziv, SimpleIntegerProperty brojStanovnika, SimpleIntegerProperty drzavaID) {
        this.gradID = gradID;
        this.naziv = naziv;
        this.brojStanovnika = brojStanovnika;
        this.drzavaID = drzavaID;
    }

    public Grad(Integer gradID, String naziv, Integer brojStanovnika, Integer drzavaID){
        this.gradID = new SimpleIntegerProperty(gradID);
        this.naziv = new SimpleStringProperty(naziv);
        this.brojStanovnika = new SimpleIntegerProperty(brojStanovnika);
        this.drzavaID = new SimpleIntegerProperty(drzavaID);
    }

    public void setGradID(int gradID) {
        this.gradID.set(gradID);
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika.set(brojStanovnika);
    }

    public void setDrzavaID(int drzavaID) {
        this.drzavaID.set(drzavaID);
    }

    public int getGradID() {
        return gradID.get();
    }

    public SimpleIntegerProperty gradIDProperty() {
        return gradID;
    }

    public String getNaziv() {
        return naziv.get();
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika.get();
    }

    public SimpleIntegerProperty brojStanovnikaProperty() {
        return brojStanovnika;
    }

    public int getDrzavaID() {
        return drzavaID.get();
    }

    public SimpleIntegerProperty drzavaIDProperty() {
        return drzavaID;
    }

    @Override
    public String toString() {
        return "Naziv: " + naziv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grad)) return false;
        Grad grad = (Grad) o;
        return Objects.equals(getGradID(), grad.getGradID()) && Objects.equals(getNaziv(), grad.getNaziv()) && Objects.equals(getBrojStanovnika(), grad.getBrojStanovnika()) && Objects.equals(getDrzavaID(), grad.getDrzavaID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGradID(), getNaziv(), getBrojStanovnika(), getDrzavaID());
    }

    //    public Grad(int ID, String naziv, int brojStanovnika, int drzavaID) {
//        this.gradID = gradID;
//        this.naziv = naziv;
//        this.brojStanovnika = brojStanovnika;
//        this.drzavaID = drzavaID;
//    }
//
//    public Grad() {
//    }
//
//    public void setGradID(int gradID) {
//        this.gradID = gradID;
//    }
//
//    public void setNaziv(String naziv) {
//        this.naziv = naziv;
//    }
//
//    public void setBrojStanovnika(int brojStanovnika) {
//        this.brojStanovnika = brojStanovnika;
//    }
//
//    public void setDrzavaID(int drzavaID) {
//        this.drzavaID = drzavaID;
//    }
//
//    public int getGradID() {
//        return gradID;
//    }
//
//    public String getNaziv() {
//        return naziv;
//    }
//
//    public int getBrojStanovnika() {
//        return brojStanovnika;
//    }
//
//    public int getDrzavaID() {
//        return drzavaID;
//    }
//
//    @Override
//    public String toString() {
//        return naziv;
//    }



}
