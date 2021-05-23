package com.bezkoder.springjwt.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String libelle;
    private String  dateDemande;
    private String status="En cours";
    @ManyToOne
    private Employe employe;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public String getDateDemande() {
        return dateDemande;
    }
    public void setDateDemande(String dateDemande) {
        this.dateDemande = dateDemande;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Employe getEmploye() {
        return employe;
    }
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }


}
