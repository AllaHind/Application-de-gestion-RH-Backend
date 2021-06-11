package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.bean.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {


    @Query("Select a from FileDB a ,User u where a.user.id=u.id  and a.user.matricule =:matricule")
    FileDB checkDocumentByUserMatricule(@Param("matricule") String matricule);

    @Query("Select a from FileDB a ,User u where a.user.id=u.id  and a.user.matricule =:matricule")
    List<FileDB> findAllByMat(@Param("matricule") String matricule);

    @Query("Select a from FileDB a ,User u where a.user.id=u.id  and a.user.email =:email")
    String getUploadDocumnetPath(@Param("email") String email);
}
