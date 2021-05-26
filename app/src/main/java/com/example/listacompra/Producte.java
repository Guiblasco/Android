package com.example.listacompra;

import android.os.Parcel;
import android.os.Parcelable;

public class Producte implements Parcelable {

    private String nomProducte;
    private String descripcioProducte;
    private int quantitat;
    private int foto;
    private Boolean selected;

    private boolean checked;

    public Producte(String nom, String descripcio, int foto) {
        this.nomProducte  = nom;
        this.descripcioProducte = descripcio;
        this.foto = foto;
        this.selected = false;
        this.quantitat = 0;
    }

    protected Producte(Parcel in) {
        nomProducte = in.readString();
        descripcioProducte = in.readString();
        quantitat = in.readInt();
        foto = in.readInt();
        byte tmpSelected = in.readByte();
        selected = tmpSelected == 0 ? null : tmpSelected == 1;
        checked = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Producte> CREATOR = new Creator<Producte>() {
        @Override
        public Producte createFromParcel(Parcel in) {
            return new Producte(in);
        }

        @Override
        public Producte[] newArray(int size) {
            return new Producte[size];
        }
    };

    public Producte() {

    }

    public String getNomProducte() {
        return nomProducte;
    }

    public void setNomProducte(String nomProducte) {
        this.nomProducte = nomProducte;
    }

    public String getDescripcioProducte() {
        return descripcioProducte;
    }

    public void setDescripcioProducte(String descripcioProducte) {
        this.descripcioProducte = descripcioProducte;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked)     {
        this.checked = checked;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nomProducte);
        parcel.writeString(descripcioProducte);
        parcel.writeInt(quantitat);
        parcel.writeInt(foto);
        parcel.writeByte((byte) (selected == null ? 0 : selected ? 1 : 2));
        parcel.writeByte((byte) (checked ? 1 : 0));
    }
}

