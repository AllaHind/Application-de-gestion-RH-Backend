package com.bezkoder.springjwt.repository;


import java.util.Optional;

import com.bezkoder.springjwt.bean.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    Optional<ImageModel> findByName(String name);
}
