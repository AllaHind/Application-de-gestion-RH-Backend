package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Service.DemandeAbsenceService;
import com.bezkoder.springjwt.bean.DemandeAbsence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/DemandeAbsenceProvided")
public class DemandeAbsenceProvided {

    @Autowired
    private DemandeAbsenceService absenceService;


    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return absenceService.deleteByRef(ref);
    }
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


}