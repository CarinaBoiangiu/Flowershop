package com.details.FlowerShop.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name =  "comanda")
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "comanda_buchete",
            joinColumns = @JoinColumn(name = "comanda_id"),
            inverseJoinColumns = @JoinColumn(name = "buchet_id")
    )
    private List<Buchet> buchete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public List<Buchet> getBuchete() {
        return buchete;
    }

    public void setBuchete(List<Buchet> buchete) {
        this.buchete = buchete;
    }
}
