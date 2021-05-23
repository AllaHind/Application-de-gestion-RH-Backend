package com.bezkoder.springjwt.Service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.bezkoder.springjwt.bean.Employe;
import com.bezkoder.springjwt.controllers.AuthController;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.EmployeDao;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeService {
    @Autowired
    private AuthController authController;
@Autowired
private UserRepository userRepository;
    @Autowired
    private EmployeDao employeDao;
    @Autowired
    private DemandeAbsenceService demandeAbsenceService;
    public Employe findByMatricule(String matricule) {
        return employeDao.findByMatricule(matricule);
    }

    @Transactional
    public int deleteByMatricule(String matricule) {
        return
                employeDao.deleteByMatricule(matricule);
    }

    public int save(Employe employe) {
        if (findByMatricule(employe.getMatricule()) != null) {
            return -1;
        }

        else {

            employeDao.save(employe);

            return 1;
        }

    }

    public List<Employe> findAll() {
        return employeDao.findAll();
    }

    @Transactional
    public void deleteAll() {
        employeDao.deleteAll();
    }


    public Employe findEmp() {
        return employeDao.findEmp();
    }
}