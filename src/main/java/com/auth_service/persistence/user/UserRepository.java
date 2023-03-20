package com.auth_service.persistence.user;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.auth_service.security.authority.Role;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>, CrudRepository<User, Long>{
	
	Optional<User> findByEmail(String email);
	
	Page<User> findByNamesContaining(String keyword, Pageable pageable);

	@Transactional
	@Modifying
	@Query("update User set role = :role where email = : email")
	User changeRole(@Param("email") String email, @Param("role") Role role);

}
