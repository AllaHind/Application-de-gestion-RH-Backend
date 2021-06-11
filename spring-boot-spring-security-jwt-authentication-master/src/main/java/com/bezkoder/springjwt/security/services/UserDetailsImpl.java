package com.bezkoder.springjwt.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.bezkoder.springjwt.bean.Employe;
import com.bezkoder.springjwt.bean.Equipe;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bezkoder.springjwt.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private String fullname;

	private Collection<? extends GrantedAuthority> authorities;
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

	@ManyToOne
	Equipe equipe;

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public UserDetailsImpl(Long id, String username, String email, String password, String fullname,
						   Collection<? extends GrantedAuthority> authorities, String matricule, String date_naissance, String anciennete, String dateEmbauche, String responsable, String uniteOrgani, int indice, String echelle, String echelon, String datechelle, String datechelon, Equipe equipe) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.authorities = authorities;
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

	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getId(), 
				user.getUsername(), 
				user.getEmail(),
				user.getPassword(),
				user.getFullname(),
				authorities,user.getMatricule(),user.getDate_naissance(),user.getAnciennete(),user.getDateEmbauche(),user.getResponsable(),user.getUniteOrgani(),user.getIndice(),user.getEchelle(),user.getEchelon(),user.getDatechelle(),user.getDatechelon(),user
		.getEquipe());






	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
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

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}


	public String getFullname() {
		return fullname;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
