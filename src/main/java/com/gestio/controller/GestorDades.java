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
        Usuari u1 = new Usuari("Laura", "García", "Martínez", "12345678A", "600111222");
        Usuari u2 = new Usuari("Marc", "Rosselló", "López", "87654321B", "600333444");
        usuaris.add(u1);
        usuaris.add(u2);

        Joc j1 = new Joc("The Legend of Zelda", "Aventura");
        j1.setUnitatsPlataforma("PS5", 2);
        j1.setUnitatsPlataforma("Switch 2", 2);

        Joc j2 = new Joc("Cyberpunk 2077", "Acció");
        j2.setUnitatsPlataforma("Xbox", 1);
        j2.setUnitatsPlataforma("PC", 2);

        jocs.add(j1);
        jocs.add(j2);

        registrarLloguer(j1, u1, "Switch 2", LocalDate.now().minusDays(5), LocalDate.now().plusDays(2));
        registrarLloguer(j2, u2, "PC", LocalDate.now().minusDays(10), LocalDate.now().minusDays(3)); // Fora de termini per provar el vermell
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
    
    public boolean teLloguersActiusUsuari(Usuari u) {
        for (Lloguer l : lloguers) {
            if (!l.isRetornat() && l.getUsuari().equals(u)) {
                return true;
            }
        }
        return false;
    }

    public boolean esborrarUsuari(Usuari u) {
        if (teLloguersActiusUsuari(u)) {
            return false;
        }
        return usuaris.remove(u);
    }

    public boolean teLloguersActiusJoc(Joc j) {
        for (Lloguer l : lloguers) {
            if (!l.isRetornat() && l.getJoc().equals(j)) {
                return true;
            }
        }
        return false;
    }

    public boolean esborrarJoc(Joc j) {
        if (teLloguersActiusJoc(j)) {
            return false;
        }
        return jocs.remove(j);
    }

    public List<Usuari> getUsuaris() { return usuaris; }
    public List<Joc> getJocs() { return jocs; }
    public List<Lloguer> getLloguers() { return lloguers; }
}