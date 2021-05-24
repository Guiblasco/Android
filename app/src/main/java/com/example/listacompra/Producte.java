package com.example.listacompra;

public class Producte {

    String nom;
    String foto;
    int quantitat;

    public Producte(){

    };

    public Producte(String nom, String foto, int quantitat) {
        this.nom = nom;
        this.foto = foto;
        this.quantitat = quantitat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public String getFoto() {
        return foto;
    }
}

