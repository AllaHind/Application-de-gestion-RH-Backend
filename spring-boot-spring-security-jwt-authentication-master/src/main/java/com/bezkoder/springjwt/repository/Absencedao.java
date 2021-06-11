package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.bean.DemandeAbsence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.*;
import java.util.Optional;
import   java.util.List;

public interface Absencedao extends JpaRepository<DemandeAbsence,Long> {

    Optional<DemandeAbsence> findById(Long id);
    int deleteByRef(String ref);
	/*List<DemandeAbsence> findByEmployeMatricule(String matricule);
	int deleteByEmployeMatricule(String matricule);*/


    List<DemandeAbsence> findByUserId(Long id);

    @Query("SELECT a from DemandeAbsence  a where a.status<>'brouillon'")
    List<DemandeAbsence> listAdm();


    @Query("SELECT 27-SUM(nombrejours) FROM DemandeAbsence d where d.user.id=:id and d.type='Congé' and d.status='acceptée' ")
    int sommeSolde(@Param("id") Long id);

    @Query("SELECT count(*) FROM DemandeAbsence d where d.user.id=:id  and d.status='Approuvée' ")
    int DemandeApprouve(@Param("id") Long id);

    @Query("SELECT count(*) FROM DemandeAbsence d where d.user.id=:id  and d.status='Rejetée' ")
    int DemandeRejetee(@Param("id") Long id);
    @Query("SELECT count(*) FROM DemandeAbsence d where d.user.id=:id  and d.status='En cours de traitement' ")
    int DemandeEncours(@Param("id") Long id);
}
