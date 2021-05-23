package com.bezkoder.springjwt.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.bezkoder.springjwt.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


    @Entity
    public class Employe  {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)

        private Long  id;private String nomComplet;
        private String matricule;

        private String date_naissance;
        private String anciennete;
        private String dateEmbauche;
        private String responsable;
        private String emploi;
        private String uniteOrgani;
        private int indice;
        private String echelle;
        private String echelon;
        private String datechelle;
        private String datechelon;
        private int solde=30;

/*
@JsonProperty(access = Access.WRITE_ONLY)
@OneToMany(mappedBy = "employe")
*/
/*
private List<DemandeAbsence> absences;
*/
/*@JsonProperty(access = Access.WRITE_ONLY)
@OneToMany(mappedBy = "employe")
private List<Document> documents;*/

        /*@OneToOne(cascade=CascadeType.ALL)
        private Login login;
        */
/*
public List<DemandeAbsence> getAbsences() {
	return absences;
}

public void setAbsences(List<DemandeAbsence> absences) {
	this.absences = absences;
}
*/
        public String getString_naissance() {
            return date_naissance;
        }
        public void setString_naissance(String date_naissance) {
            this.date_naissance = date_naissance;
        }
        /*public Login getLogin() {
            return login;
        }
        public void setLogin(Login login) {
            this.login = login;
        }
        */
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getMatricule() {
            return matricule;
        }
        public void setMatricule(String matricule) {
            this.matricule = matricule;
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
        public String getStringchelle() {
            return datechelle;
        }
        public void setStringchelle(String datechelle) {
            this.datechelle = datechelle;
        }
        public String getStringchelon() {
            return datechelon;
        }
        public void setStringchelon(String datechelon) {
            this.datechelon = datechelon;
        }
        public String getAnciennete() {
            return anciennete;
        }
        public void setAnciennete(String anciennete) {
            this.anciennete = anciennete;
        }
        public String getStringEmbauche() {
            return dateEmbauche;
        }
        public void setStringEmbauche(String dateEmbauche) {
            this.dateEmbauche = dateEmbauche;
        }
        public String getResponsable() {
            return responsable;
        }
        public void setResponsable(String responsable) {
            this.responsable = responsable;
        }
        public String getEmploi() {
            return emploi;
        }
        public void setEmploi(String emploi) {
            this.emploi = emploi;
        }
        public String getUniteOrgani() {
            return uniteOrgani;
        }
        public void setUniteOrgani(String uniteOrgani) {
            this.uniteOrgani = uniteOrgani;
        }
        public String getNomComplet() {
            return nomComplet;
        }
        public void setNomComplet(String nomComplet) {
            this.nomComplet = nomComplet;
        }
        public String getDate_naissance() {
            return date_naissance;
        }
        public void setDate_naissance(String date_naissance) {
            this.date_naissance = date_naissance;
        }
        public String getDateEmbauche() {
            return dateEmbauche;
        }
        public void setDateEmbauche(String dateEmbauche) {
            this.dateEmbauche = dateEmbauche;
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

        /*public List<Document> getDocuments() {
            return documents;
        }

        public void setDocuments(List<Document> documents) {
            this.documents = documents;
        }
        */
        public int getSolde() {
            return solde;
        }
        public void setSolde(int solde) {
            this.solde = solde;
        }



    }


