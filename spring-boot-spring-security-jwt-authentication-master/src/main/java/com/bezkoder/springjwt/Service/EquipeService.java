package com.bezkoder.springjwt.Service;

import com.bezkoder.springjwt.bean.Equipe;
import com.bezkoder.springjwt.repository.EquipeDao;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

 @Autowired
 private EquipeDao equipeDao;
 @Autowired
 private UserDetailsServiceImpl userservice;

    public Equipe findByName(String name) {
        return equipeDao.findByName(name);
    }

    public int save(Equipe equipe) {
        if (findByName(equipe.getName())!=null){
            return -1;
        }

        else {

            equipeDao.save(equipe);
            userservice.save(equipe, equipe.getUsers());

            return 1;
        }
    }

    public List<Equipe> findAll() {
        return equipeDao.findAll();
    }
}
