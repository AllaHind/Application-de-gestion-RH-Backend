package com.bezkoder.springjwt.controllers;

import java.util.List;

import com.bezkoder.springjwt.Service.EmployeService;
import com.bezkoder.springjwt.bean.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("Employe-Provided")
public class EmployeProvided {

    @Autowired
    private EmployeService employeService;


    @GetMapping("/matricule/{matricule}")
    public Employe findByMatricule(@PathVariable String matricule) {
        return employeService.findByMatricule(matricule);
    }
    @DeleteMapping("/matricule/{matricule}")
    public int deleteByMatricule(@PathVariable String matricule) {
        return employeService.deleteByMatricule(matricule);
    }
    @PostMapping("/")
    public int save(@RequestBody Employe employe) {
        return employeService.save(employe);
    }
    @GetMapping("/")
    public List<Employe> findAll() {
        return employeService.findAll();
    }
    @DeleteMapping("/")
    public void deleteAll() {
        employeService.deleteAll();
    }
    @GetMapping("/emp")
    public Employe findEmp() {
        return employeService.findEmp();
    }





}
