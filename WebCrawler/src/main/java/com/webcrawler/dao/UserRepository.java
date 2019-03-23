package com.webcrawler.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserDetailsModel, Long> {

	@Query(value = "SELECT * FROM user_details WHERE email=:email", nativeQuery = true)
	public UserDetailsModel findByEmail(@Param("email") String email);
}
