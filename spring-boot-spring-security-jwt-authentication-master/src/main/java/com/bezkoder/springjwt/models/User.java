package com.bezkoder.springjwt.models;

import com.bezkoder.springjwt.bean.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	private String password2;

	private String fullname;

	private String phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<>();

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
private boolean chefService;
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

	/*private  int solde=30;

        public int getSolde() {
            return solde;
        }

        public void setSolde(int solde) {
            this.solde = solde;
        }*/
	@ManyToOne
	private Equipe equipe;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "user")
	private List<DemandeAbsence> demandeAbsences;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "user")
	private List<Document> documents;


	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "user")
	private List<FileDB> fileDBList;

	public List<FileDB> getFileDBList() {
		return fileDBList;
	}

	public void setFileDBList(List<FileDB> fileDBList) {
		this.fileDBList = fileDBList;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public User() {
	}

	public User(String username, String email, String password,String password2,String fullname,String matricule,String date_naissance,String anciennete,String dateEmbauche,String responsable,String uniteOrgani,int indice,String echelle,String echelon,String datechelle,String datechelon,Equipe equipe,String emmploi) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.password2 = password2;
		this.fullname=fullname;
		this.matricule=matricule;
		this.date_naissance=date_naissance;
		this.anciennete=anciennete;
		this.dateEmbauche=dateEmbauche;
		this.responsable=responsable;
		this.uniteOrgani=uniteOrgani;
		this.indice=indice;
		this.echelle=echelle;
		this.echelon=echelon;
		this.datechelle=datechelle;
		this.datechelon=datechelon;
		this.setEquipe(equipe);
		this.emmploi=emmploi;

	}
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public List<DemandeAbsence> getDemandeAbsences() {
		return demandeAbsences;
	}

	public void setDemandeAbsences(List<DemandeAbsence> demandeAbsences) {
		this.demandeAbsences = demandeAbsences;
	}

}
