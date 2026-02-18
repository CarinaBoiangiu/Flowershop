package com.details.FlowerShop.model;

import jakarta.persistence.*;

import javax.swing.*;

@Entity
@Table(name="buchete")
public class Buchet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String denumireBuchet;
    @Column(nullable = false)
    private String descriere;
    @Column(nullable = false)
    private double pret;

    @Transient
    private ImageIcon img;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public double getPret() {
        return pret;
    }

    public ImageIcon getImg() {
        return img;
    }

    public String getDenumireBuchet() {
        return denumireBuchet;
    }

    public void setDenumireBuchet(String denumireBuchet) {
        this.denumireBuchet = denumireBuchet;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }
}
