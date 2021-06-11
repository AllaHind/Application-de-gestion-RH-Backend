package com.bezkoder.springjwt.payload.request;

import com.bezkoder.springjwt.bean.Equipe;

import java.util.List;
import java.util.Set;

import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    private List<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    private String password2;
private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String fullname;
    private String matricule;
    private String date_naissance;
    private String anciennete;
    private String dateEmbauche;
    private String responsable;
    private String uniteOrgani;
    private int indice=30;
    private String echelle;
    private String echelon;
    private String datechelle;
    private String datechelon;
    private String emmploi;

    public String getEmmploi() {
        return emmploi;
    }

    public void setEmmploi(String emmploi) {
        this.emmploi = emmploi;
    }

    @ManyToOne
    private Equipe equipe;

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(String anciennete) {
        this.anciennete = anciennete;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }



    public String getUniteOrgani() {
        return uniteOrgani;
    }

    public void setUniteOrgani(String uniteOrgani) {
        this.uniteOrgani = uniteOrgani;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getEchelle() {
        return echelle;
    }

    public void setEchelle(String echelle) {
        this.echelle = echelle;
    }

    public String getEchelon() {
        return echelon;
    }

    public void setEchelon(String echelon) {
        this.echelon = echelon;
    }

    public String getDatechelle() {
        return datechelle;
    }

    public void setDatechelle(String datechelle) {
        this.datechelle = datechelle;
    }

    public String getDatechelon() {
        return datechelon;
    }

    public void setDatechelon(String datechelon) {
        this.datechelon = datechelon;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }


    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
