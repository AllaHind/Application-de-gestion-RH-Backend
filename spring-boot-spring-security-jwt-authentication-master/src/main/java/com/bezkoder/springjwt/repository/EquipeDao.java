package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.bean.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeDao extends JpaRepository<Equipe, Long> {

    Equipe findByName(String  name);
}
