package com.bezkoder.springjwt.models;

import com.bezkoder.springjwt.bean.DemandeAbsence;
import com.bezkoder.springjwt.bean.Employe;

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

	private String fullname;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
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

	@OneToMany(mappedBy = "user")
	private List<DemandeAbsence> demandeAbsences;


	public User() {
	}

	public User(String username, String email, String password,String fullname,String matricule,String date_naissance,String anciennete,String dateEmbauche,String responsable,String emploi,String uniteOrgani,int indice,String echelle,String echelon,String datechelle,String datechelon) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname=fullname;
		this.matricule=matricule;
		this.date_naissance=date_naissance;
		this.anciennete=anciennete;
		this.dateEmbauche=dateEmbauche;
		this.responsable=responsable;
		this.emploi=emploi;
		this.uniteOrgani=uniteOrgani;
		this.indice=indice;
		this.echelle=echelle;
		this.echelon=echelon;
		this.datechelle=datechelle;
		this.datechelon=datechelon;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
