package com.details.FlowerShop.model;

import jakarta.persistence.*;

@Entity
@Table(name="buchete")
public class Buchet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String denumireBuchet;

    @Column(nullable = false, length = 1000)
    private String descriere;

    @Column(nullable = false)
    private double pret;

    // Folosim un String pentru calea imaginii (ex: "/images/trandafir.jpg")
    @Column(name = "image_url")
    private String imageUrl;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getDenumireBuchet() { return denumireBuchet; }
    public void setDenumireBuchet(String denumireBuchet) { this.denumireBuchet = denumireBuchet; }

    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }

    public double getPret() { return pret; }
    public void setPret(double pret) { this.pret = pret; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}