package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Service.EquipeService;
import com.bezkoder.springjwt.bean.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/Equipe")
public class EquipeController {
    @Autowired
    private EquipeService equipeService;
@GetMapping("/name/{name}")
    public Equipe findByName(@PathVariable String name) {
        return equipeService.findByName(name);
    }
    @PostMapping("/")
    public int save(@RequestBody Equipe equipe) {
        return equipeService.save(equipe);
    }

    @GetMapping("/")
    public List<Equipe> findAll() {
        return equipeService.findAll();
    }
}
