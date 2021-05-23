package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.bean.DemandeAbsence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.*;
import java.util.Optional;
import   java.util.List;

public interface Absencedao extends JpaRepository<DemandeAbsence,Long> {

    Optional<DemandeAbsence> findById(Long id);
    int deleteByRef(String ref);
	/*List<DemandeAbsence> findByEmployeMatricule(String matricule);
	int deleteByEmployeMatricule(String matricule);*/

    @Query("SELECT a from DemandeAbsence  a where a.status<>'brouillon'")
    List<DemandeAbsence> listAdm();
}
