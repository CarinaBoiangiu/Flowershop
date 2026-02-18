package com.details.FlowerShop.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comanda> comenzi = new ArrayList<>();

    @ManyToMany
    private List<Buchet> saveBuchet = new ArrayList<>();

    public User() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Comanda> getComenzi() { return comenzi; }
    public void setComenzi(List<Comanda> comenzi) { this.comenzi = comenzi; }

    public List<Buchet> getSaveBuchet() { return saveBuchet; }
    public void setSaveBuchet(List<Buchet> saveBuchet) { this.saveBuchet = saveBuchet; }
}