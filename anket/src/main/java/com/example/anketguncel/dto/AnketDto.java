package com.example.anketguncel.dto;


import lombok.Data;

import java.util.Date;

public class AnketDto {

    public int id;
    public String anketorAdi;
    public String anketorSoyAdi;

    public String adi;
    public String soyadi;
    public int cinsiyet;
    public Date dogumGunu;
    public String takim;
    public String aciklama;
    public int mutlulukOrani;
    public String mutluEden;
    public String mutsuzEden;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnketorAdi() {
        return anketorAdi;
    }

    public void setAnketorAdi(String anketorAdi) {
        this.anketorAdi = anketorAdi;
    }

    public String getAnketorSoyAdi() {
        return anketorSoyAdi;
    }

    public void setAnketorSoyAdi(String anketorSoyAdi) {
        this.anketorSoyAdi = anketorSoyAdi;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public int getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(int cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public Date getDogumGunu() {
        return dogumGunu;
    }

    public void setDogumGunu(Date dogumGunu) {
        this.dogumGunu = dogumGunu;
    }

    public String getTakim() {
        return takim;
    }

    public void setTakim(String takim) {
        this.takim = takim;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public int getMutlulukOrani() {
        return mutlulukOrani;
    }

    public void setMutlulukOrani(int mutlulukOrani) {
        this.mutlulukOrani = mutlulukOrani;
    }

    public String getMutluEden() {
        return mutluEden;
    }

    public void setMutluEden(String mutluEden) {
        this.mutluEden = mutluEden;
    }

    public String getMutsuzEden() {
        return mutsuzEden;
    }

    public void setMutsuzEden(String mutsuzEden) {
        this.mutsuzEden = mutsuzEden;
    }
}

