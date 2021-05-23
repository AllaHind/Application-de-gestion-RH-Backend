package com.bezkoder.springjwt.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.bezkoder.springjwt.models.User;

import java.util.Optional;

@Entity
public class DemandeAbsence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long  id;
    private String type;
    private String ref;
    private int nombrejours;
    private String firstDay;
    private String lastDay;
    private String interim;
    private String status;
    private String typeConge;
    private String motif;
    private String reprise;

    @ManyToOne
    private User user;

    /*
    @ManyToOne
        private Employe employe;

        */
    public String getRef() {
        return ref;
    }
    public int getNombrejours() {
        return nombrejours;
    }
    public void setNombrejours(int nombrejours) {
        this.nombrejours = nombrejours;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
    public String getReprise() {
        return reprise;
    }
    public void setReprise(String reprise) {
        this.reprise = reprise;
    }
    public String getTypeConge() {
        return typeConge;
    }
    public void setTypeConge(String typeConge) {
        this.typeConge = typeConge;
    }
    /*public Login getLogin() {
        return login;
    }
    public void setLogin(Login login) {
        this.login = login;
    }
    */
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    /*
public Employe getEmploye() {
        return employe;
    }
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    */
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getFirstDay() {
        return firstDay;
    }
    public void setFirstDay(String firstDay) {
        this.firstDay = firstDay;
    }
    public String getLastDay() {
        return lastDay;
    }
    public void setLastDay(String lastDay) {
        this.lastDay = lastDay;
    }
    public String getInterim() {
        return interim;
    }
    public void setInterim(String interim) {
        this.interim = interim;
    }
    public String getMotif() {
        return motif;
    }
    public void setMotif(String motif) {
        this.motif = motif;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
