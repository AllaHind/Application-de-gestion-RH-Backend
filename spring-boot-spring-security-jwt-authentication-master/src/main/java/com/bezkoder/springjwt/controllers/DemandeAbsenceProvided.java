package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Service.DemandeAbsenceService;
import com.bezkoder.springjwt.bean.DemandeAbsence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("DemandeAbsenceProvided")
public class DemandeAbsenceProvided {


    @Autowired
    private DemandeAbsenceService absenceService;



    @PutMapping("/")
    public int update(@RequestBody DemandeAbsence demandeAbsence) {
        return absenceService.update(demandeAbsence);
    }

    /*@GetMapping("/employe/matricule/{matricule}")
        public List<DemandeAbsence> findByEmployeMatricule(@PathVariable String matricule) {
            return absenceService.findByEmployeMatricule(matricule);
        }*/
/*@DeleteMapping("/employe/matricule/{matricule}")
	public int deleteByEmployeMatricule(String matricule) {
		return absenceService.deleteByEmployeMatricule(matricule);
	}*/
    @PostMapping("/")
    public int save(@RequestBody DemandeAbsence absence) {
        return absenceService.save(absence);
    }

    @GetMapping("/all")
    public List<DemandeAbsence> findAll() {
        return absenceService.findAll();
    }

    @GetMapping("/list-adm")
    public List<DemandeAbsence> listAdm() {
        return absenceService.listAdm();
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        absenceService.deleteById(id);
    }

    /*@GetMapping("/sommeAbsence")
    public int SommeAbsence() {
        return absenceService.SommeAbsence();

    }
    @GetMapping("/soldeRestant")
    public int soldeRestant() {
        return absenceService.soldeRestant();
    }*/
    @GetMapping("/id/{id}")
    public List<DemandeAbsence> findByUserId(@PathVariable Long id) {
        return absenceService.findByUserId(id);
    }

@GetMapping("/somme/{id}")
    @Query("SELECT 27-SUM(nombrejours) FROM DemandeAbsence d where d.user.id=:id and d.type='Congé' and d.status='acceptée' ")
    public int sommeSolde(@PathVariable Long id) {
        return absenceService.sommeSolde(id);
    }
@GetMapping("/demande/{id}")
    @Query("SELECT count(*) FROM DemandeAbsence d where d.user.id=:id  and d.status='Approuvée' ")
    public int DemandeApprouve(@PathVariable Long id) {
        return absenceService.DemandeApprouve(id);
    }
    @GetMapping("/demandeRejete/{id}")
    @Query("SELECT count(*) FROM DemandeAbsence d where d.user.id=:id  and d.status='Rejetée' ")
    public int DemandeRejetee(@PathVariable Long id) {
        return absenceService.DemandeRejetee(id);
    }
    @GetMapping("/demandeEncours/{id}")
    @Query("SELECT count(*) FROM DemandeAbsence d where d.user.id=:id  and d.status='En cours de traitement' ")
    public int DemandeEncours(@PathVariable Long id) {
        return absenceService.DemandeEncours(id);
    }
}