package com.gestio.model;

import java.time.LocalDate;

public class Lloguer {
    private String id; // p.ex. "06"
    private Joc joc;
    private Usuari usuari;
    private String plataforma;
    private LocalDate dataInici;
    private LocalDate dataTornada;
    private boolean retornat;

    public Lloguer(String id, Joc joc, Usuari usuari, String plataforma, LocalDate dataInici, LocalDate dataTornada) {
        this.id = id;
        this.joc = joc;
        this.usuari = usuari;
        this.plataforma = plataforma;
        this.dataInici = dataInici;
        this.dataTornada = dataTornada;
        this.retornat = false;
    }

    public String getId() { return id; }
    public Joc getJoc() { return joc; }
    public Usuari getUsuari() { return usuari; }
    public String getPlataforma() { return plataforma; }
    public LocalDate getDataInici() { return dataInici; }
    public LocalDate getDataTornada() { return dataTornada; }
    public boolean isRetornat() { return retornat; }
    public void setRetornat(boolean retornat) { this.retornat = retornat; }
}
