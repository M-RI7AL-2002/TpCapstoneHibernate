package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank (message = "le nom est obligatoire")
    @Column(length = 50, nullable = false)
    private String nom;
    @NotBlank (message = "le prenom est obligatoire")
    @Column(length = 50, nullable = false)
    private String prenom;

    @NotBlank(message = "Email est obligatoire")
    @Email(message = "format email invalid")
    @Column(unique = true, nullable = false)
    private String email;

    // Relation OneToMany avec Réservation
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    public Utilisateur() {

    }

    public Utilisateur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setUtilisateur(this);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.setUtilisateur(null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
