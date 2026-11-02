package com.gestio.model;

import java.util.HashMap;
import java.util.Map;

public class Joc {
    private String nom;
    private String genere;
    private Map<String, Integer> unitatsPerPlataforma; // ex: "PS5" -> 3, "PC" -> 1

    public Joc(String nom, String genere) {
        this.nom = nom;
        this.genere = genere;
        this.unitatsPerPlataforma = new HashMap<>();
    }

    public void setUnitatsPlataforma(String plataforma, int unitats) {
        if (unitats > 0) {
            unitatsPerPlataforma.put(plataforma, unitats);
        } else {
            unitatsPerPlataforma.remove(plataforma);
        }
    }

    public int getUnitatsPlataforma(String plataforma) {
        return unitatsPerPlataforma.getOrDefault(plataforma, 0);
    }

    public boolean decrementarUnitat(String plataforma) {
        int actuals = getUnitatsPlataforma(plataforma);
        if (actuals > 0) {
            unitatsPerPlataforma.put(plataforma, actuals - 1);
            return true;
        }
        return false;
    }

    public void incrementarUnitat(String plataforma) {
        unitatsPerPlataforma.put(plataforma, getUnitatsPlataforma(plataforma) + 1);
    }

    public String getNom() { return nom; }
    public String getGenere() { return genere; }
    public Map<String, Integer> getUnitatsPerPlataforma() { return unitatsPerPlataforma; }

    @Override
    public String toString() {
        return nom;
    }
}