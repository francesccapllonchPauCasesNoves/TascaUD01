package com.gestio.controller;

import com.gestio.model.Joc;
import com.gestio.model.Lloguer;
import com.gestio.model.Usuari;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorDades {
    private static GestorDades instancia;
    private final List<Usuari> usuaris;
    private final List<Joc> jocs;
    private final List<Lloguer> lloguers;
    private int contadorLloguers = 1;

    private GestorDades() {
        usuaris = new ArrayList<>();
        jocs = new ArrayList<>();
        lloguers = new ArrayList<>();
        carregarDadesInicials();
    }

    public static synchronized GestorDades getInstancia() {
        if (instancia == null) {
            instancia = new GestorDades();
        }
        return instancia;
    }

    private void carregarDadesInicials() {
        Usuari u1 = new Usuari("Laura", "García", "", "12345678A", "600111222");
        Usuari u2 = new Usuari("Marc", "López", "", "87654321B", "600333444");
        usuaris.add(u1);
        usuaris.add(u2);

        Joc j1 = new Joc("Cyberpunk 2077", "Acció");
        j1.setUnitatsPlataforma("PC", 1);
        j1.setUnitatsPlataforma("PS5", 0);

        Joc j2 = new Joc("Minecraft", "Aventura");
        j2.setUnitatsPlataforma("Switch 2", 2);

        jocs.add(j1);
        jocs.add(j2);
    }

    public void afegirUsuari(Usuari u) { usuaris.add(u); }
    public void afegirJoc(Joc j) { jocs.add(j); }

    public String generarSeguentIdLloguer() {
        return String.format("%02d", contadorLloguers++);
    }

    public boolean registrarLloguer(Joc joc, Usuari usuari, String plataforma, LocalDate inici, LocalDate tornada) {
        if (joc.decrementarUnitat(plataforma)) {
            Lloguer lloguer = new Lloguer(generarSeguentIdLloguer(), joc, usuari, plataforma, inici, tornada);
            lloguers.add(0, lloguer); 
            return true;
        }
        return false;
    }

    public void marcarComARetornat(Lloguer lloguer) {
        if (!lloguer.isRetornat()) {
            lloguer.setRetornat(true);
            lloguer.getJoc().incrementarUnitat(lloguer.getPlataforma());
        }
    }

    public List<Usuari> getUsuaris() { return usuaris; }
    public List<Joc> getJocs() { return jocs; }
    public List<Lloguer> getLloguers() { return lloguers; }
}