package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.bean.DemandeAbsence;
import com.bezkoder.springjwt.bean.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentDao  extends JpaRepository<Document, Long> {

    List<Document> findByUserId(Long id);

}
