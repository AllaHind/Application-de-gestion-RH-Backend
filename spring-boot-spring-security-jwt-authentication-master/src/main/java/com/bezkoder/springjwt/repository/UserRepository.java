package com.bezkoder.springjwt.repository;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.bean.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);


	User findByEmail(String email);
	User findByMatricule(String matricule);
	Boolean existsByUsername(String username);
	Boolean existsByMatricule(String matricule);

	@Query("Select u from User u where u.id<>:id")
	List<User> find(@Param("id") Long id);

	Boolean existsByEmail(String email);

	@Override
	Optional<User> findById(Long id);

	@Override
	List<User> findAll();


}
