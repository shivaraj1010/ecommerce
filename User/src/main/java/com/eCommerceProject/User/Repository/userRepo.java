package com.eCommerceProject.User.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eCommerceProject.User.entity.user;

@Repository
public interface userRepo extends JpaRepository<user,Long> {

	user findByEmail(String email);

	

}
