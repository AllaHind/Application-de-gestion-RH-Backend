package com.bezkoder.springjwt.payload.response;

import com.bezkoder.springjwt.bean.Employe;

import javax.persistence.OneToOne;
import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private List<String> roles;
	private String fullname;
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




	public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles, String fullname,String matricule,String date_naissance,String anciennete,String dateEmbauche,String responsable,String emploi,String uniteOrgani,int indice,String echelle,String echelon,String datechelle,String datechelon ) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.fullname = fullname;
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

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

}
