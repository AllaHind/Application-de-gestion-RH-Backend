package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.bean.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeDao  extends JpaRepository<Employe, Long> {

    Employe findByMatricule(String matricule);
    int deleteByMatricule(String matricule);
    @Query("SELECT e from Employe e where id=266")
    Employe findEmp();



}

