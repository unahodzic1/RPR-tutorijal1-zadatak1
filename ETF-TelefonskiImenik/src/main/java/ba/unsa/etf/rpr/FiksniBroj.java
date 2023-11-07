package ba.unsa.etf.rpr;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj{

    private Grad grad; // pozivni
    private String broj; // dio broja bez pozivnog

    public String getBroj() {
        return broj;
    }

    public Grad getGrad() {
        return grad;
    }

    public FiksniBroj(Grad grad, String broj){
        this.broj = broj;
        this.grad = grad;
    }

    @Override
    public String ispisi(){
        if(grad != null && broj != null) return grad.getPozivni() + "/" + broj.substring(0,3) + "-" + broj.substring(3);
        else return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FiksniBroj)) return false;
        FiksniBroj that = (FiksniBroj) o;
        return getGrad() == that.getGrad() && Objects.equals(getBroj(), that.getBroj());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGrad(), getBroj());
    }

}