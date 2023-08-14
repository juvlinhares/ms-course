package com.devsuperior.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	//busca por email porque o email vai ser meu nome de usuário:
	User findByEmail(String email);
}
