package com.bezkoder.springjwt.Service;

import com.bezkoder.springjwt.bean.DemandeAbsence;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.Absencedao;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class DemandeAbsenceService {
@Autowired
private UserRepository userRepository;
    @Autowired
    private Absencedao absenceDao;
    @Query("SELECT SUM(nombrejours) FROM DemandeAbsence d where d.user.id=:id and d.type='Congé'  and d.status='acceptée' ")
    public int sommeSolde(Long id) {

        return absenceDao.sommeSolde(id);
    }

    @Autowired
    private EmployeService employeService;



    /*
    public List<DemandeAbsence> findByEmployeMatricule(String matricule) {
        return absenceDao.findByEmployeMatricule(matricule);
    }
    */
/*public int deleteByEmployeMatricule(String matricule) {
	return absenceDao.deleteByEmployeMatricule(matricule);
}*/
    public int save(DemandeAbsence absence) {

	User user = userRepository.findByEmail(absence.getUser().getEmail());
	absence.setUser( user);

	if (user == null || user.getId()==null) {
		return -2;
	}



	/*if((absence.getFirstDay().compareTo(absence.getLastDay()))>0)
	 {return -1;
	 }
	 Login login=LoginService.findByEmail(absence.getLogin().getEmail());
	absence.setLogin(login);
	 if(login==null)
	{return -2;

	}
	 else */
        if (absence.getNombrejours() == 0) {
            return -2;
        } else if (absence.getFirstDay().compareTo(absence.getLastDay()) > 0 || absence.getLastDay().compareTo(absence.getReprise()) > 0 || absence.getFirstDay().compareTo(absence.getReprise()) > 0) {
            return -3;
        }
        absenceDao.save(absence);
        return 1;
    }

/*
public int soldeRestant() {
	return absenceDao.soldeRestant();
}*/

    public List<DemandeAbsence> findAll() {

        return absenceDao.findAll();
    }

    public Optional<DemandeAbsence> findById(Long id) {
        return absenceDao.findById(id);
    }

    public List<DemandeAbsence> listAdm() {
        return absenceDao.listAdm();
    }

    @Transactional
    public void deleteById(Long id) {
        absenceDao.deleteById(id);
    }

    public int update(DemandeAbsence demandeAbsence) {
        absenceDao.save(demandeAbsence);
        return 1;
    }
   /* public int save(User user, List<DemandeAbsence> demandeAbsences) {
        // TODO Auto-generated method stub

        for(DemandeAbsence d:demandeAbsences)
        {
            d.setUser(user);
            absenceDao.save(d);
        }
        return 1;
    }

*/

    @Query("SELECT count(*) FROM DemandeAbsence d where d.user.id=:id  and d.status='En cours de traitement' ")
    public int DemandeEncours(Long id) {
        return absenceDao.DemandeEncours(id);
    }

    @Query("SELECT count(*) FROM DemandeAbsence d where d.user.id=:id  and d.status='Approuvée' ")
    public int DemandeApprouve(Long id) {
        return absenceDao.DemandeApprouve(id);
    }

    @Query("SELECT count(*) FROM DemandeAbsence d where d.user.id=:id  and d.status='Rejetée' ")
    public int DemandeRejetee(Long id) {
        return absenceDao.DemandeRejetee(id);
    }

    public List<DemandeAbsence> findByUserId(Long id) {
        return absenceDao.findByUserId(id);
    }





/*void AbsenceRest(DemandeAbsence demandeAbsence)
{
	int rest= demandeAbsence.getSolde()-absenceDao.SommeAbsence();

	demandeAbsence.setSolde(rest);

}*/
/*
public int SommeAbsence() {
	return absenceDao.SommeAbsence();
}*/

public int save(User user, List<DemandeAbsence> absences) {
	// TODO Auto-generated method stub
	for(DemandeAbsence d:absences)
	{
		d.setUser(user);
		absenceDao.save(d);

	}
	return 1;

}




    }


