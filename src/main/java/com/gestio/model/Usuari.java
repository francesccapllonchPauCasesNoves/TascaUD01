package com.gestio.model;

import java.time.LocalDate;

public class Usuari {
    private String nom;
    private String llinatge1;
    private String llinatge2;
    private String dni;
    private String telefon;
    private LocalDate dataRegistre;

    public Usuari(String nom, String llinatge1, String llinatge2, String dni, String telefon) {
        this.nom = nom;
        this.llinatge1 = llinatge1;
        this.llinatge2 = llinatge2;
        this.dni = dni;
        this.telefon = telefon;
        this.dataRegistre = LocalDate.now();
    }

    public String getNomComplet() {
        return nom + " " + llinatge1 + (llinatge2 != null && !llinatge2.isEmpty() ? " " + llinatge2 : "");
    }

    // Getters i Setters
    public String getNom() { return nom; }
    public String getLlinatge1() { return llinatge1; }
    public String getLlinatge2() { return llinatge2; }
    public String getDni() { return dni; }
    public String getTelefon() { return telefon; }
    public LocalDate getDataRegistre() { return dataRegistre; }

    @Override
    public String toString() {
        return getNomComplet();
    }
}