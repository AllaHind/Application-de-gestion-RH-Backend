package com.bezkoder.springjwt.controllers;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.bezkoder.springjwt.Service.DemandeAbsenceService;
import com.bezkoder.springjwt.Service.EmployeService;
import com.bezkoder.springjwt.Service.EquipeService;
import com.bezkoder.springjwt.bean.DemandeAbsence;
import com.bezkoder.springjwt.bean.Employe;
import com.bezkoder.springjwt.bean.Equipe;
import com.bezkoder.springjwt.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.LoginRequest;
import com.bezkoder.springjwt.payload.request.SignupRequest;
import com.bezkoder.springjwt.payload.response.JwtResponse;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
//import com.bezkoder.springjwt.security.jwt.JwtUtils;
import com.bezkoder.springjwt.security.services.UserDetailsImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	DemandeAbsenceService demandeAbsenceService;
	@Autowired
	AuthenticationManager authenticationManager;

@Autowired
AuthController authController;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;
@Autowired
	EquipeService equipeService;
	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(),
												 roles,userDetails.getFullname(),userDetails.getMatricule(),userDetails.getDate_naissance(),userDetails.getAnciennete(),userDetails.getDateEmbauche(),userDetails.getResponsable(),userDetails.getEmploi(),userDetails.getUniteOrgani(),userDetails.getIndice(),userDetails.getEchelle(),userDetails.getEchelon(),userDetails.getDatechelle(),userDetails.getDatechelon()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username déjà existant!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email déjà existant!"));
		}
		if (signUpRequest.getPassword().compareTo(signUpRequest.getPassword2())!=0) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Les mots de passe ne correspondent pas! "));
		}
		if (userRepository.existsByMatricule(signUpRequest.getMatricule())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Matricule déjà existants! "));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(),
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),encoder.encode(signUpRequest.getPassword2()),signUpRequest.getFullname(),signUpRequest.getMatricule(),signUpRequest.getDate_naissance(),signUpRequest.getAnciennete(),signUpRequest.getDateEmbauche(),signUpRequest.getResponsable(),signUpRequest.getResponsable(),signUpRequest.getIndice(),signUpRequest.getEchelle(),signUpRequest.getEchelon(),signUpRequest.getDatechelle(),signUpRequest.getDatechelon(),signUpRequest.getEquipe(),signUpRequest.getEmmploi()




		);

		List<String> strRoles =signUpRequest.getRole();
		List<Role> roles = new ArrayList<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles((List<Role>) roles);
		//Optional<User> user =userRepository.findByUsername(employe.getUser().getUsername());
	//	employe.setUser(user);

		/*Employe employe=employeService.findByMatricule(user.getEmploye().getMatricule());
		user.setEmploye(employe);*/
		/*Equipe equipe= equipeService.findByName(user.getEquipe().getName());
		user.setEquipe(equipe);
		if(equipe==null)
		{
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Equipe n'existe pas!"));
		}*/
		userRepository.save(user);
		//demandeAbsenceService.save(user,user.getDemandeAbsences());


		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

/*	public int save(Employe employe, User user) {
		// TODO Auto-generated method stub


			user.setEmploye(employe);
			userRepository.save(user);
		return 1;
	}
	*/
@GetMapping("/id/{id}")
	public Optional<User> findById(@PathVariable Long id) {
		return userRepository.findById(id);
	}

	@GetMapping("/findall")
	public List<User> findAll() {
		return userRepository.findAll();
	}
@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id) {
		userRepository.deleteById(id);
	}

	@GetMapping("/find/{id}")
	@Query("Select u from User u where u.id<>:id")
	List<User> find(@PathVariable Long id){
		return  userRepository.find(id);
	}

@PutMapping("/")
public int update(@RequestBody SignupRequest signupRequest) {

	return authController.update1(signupRequest);
}
	public int update1(SignupRequest signupRequest) {
		authController.registerUser(signupRequest);
		return 1;
	}


}
