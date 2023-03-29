package com.eCommerceProject.User.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerceProject.User.Repository.userRepo;
import com.eCommerceProject.User.entity.user;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;
//import com.eCommerceProject.User.proxy.userProxy;

@RestController
public class userController {
	
	@Autowired
	private userRepo repositry;
	
//	@Autowired
//	private userProxy proxy;
	
	@PostMapping("/createUser")
	public user saveUser(@RequestBody user user) {
		
		user users=repositry.save(user);
		
		  new user(users.getUserId(),users.getFirstName(),users.getMiddleName(),users.getLastName(),users.getAddress(),
				users.getPhoneNumber(),users.getEmail(),users.getDateOfBirth(),users.getGender(),users.getPassword(),users.getCreatedDate(),users.getUpdatedDate());
		//System.out.println(users.getGender());
//		return us;

	}
	
	@GetMapping("/getAllUser")
	public List<user> getUser() {
		
		List<user> us =repositry.findAll();
		
		System.out.println(us);
		
		return us;
	}
	
	@GetMapping("/user/{id}")
	public Optional<user> getUserId(@PathVariable Long userId) {
		
		Optional<user> us =repositry.findById(userId);
		
		System.out.println(us);
		
		return us;
	}
	
	@PutMapping(value="/user/{id}")
	public String updateUserId(@PathVariable Long userId,@RequestBody user users) {
		
		if(userId!= 0) {
			boolean isIdAvailable=repositry.existsById(userId);
			if(isIdAvailable==true) {
				user us=new user(users.getUserId(),users.getFirstName(),users.getMiddleName(),users.getLastName(),users.getAddress(),
						users.getPhoneNumber(),users.getEmail(),users.getDateOfBirth(),users.getGender(),users.getPassword(),users.getCreatedDate(),users.getUpdatedDate());
				user use=repositry.save(us);
				
				return "sucessfull";
			
			}else {
				return "id is not available";
			}
			
		}
		return "enter a valid id";
			
	}
	
	@DeleteMapping(value="/user/{id}")
	public String deleteUserId(@PathVariable Long userId) {
		
		if(userId!= 0) {
			boolean isIdAvailable=repositry.existsById(userId);
			if(isIdAvailable==true) {
				
				
				repositry.deleteById(userId);
				
				return "sucessfull deleted";
			
			}else {
				return "id is not available";
			}
			
		}
		return "enter a valid id";
			
	}
	
	@GetMapping(value = "/email/{email}")
	public user findByEmail(@PathVariable String email,user users) {
		
		 user us=repositry.findByEmail(email);
		 return new user(users.getUserId(),users.getFirstName(),users.getMiddleName(),users.getLastName(),users.getAddress(),
					users.getPhoneNumber(),users.getEmail(),users.getDateOfBirth(),users.getGender(),users.getPassword(),users.getCreatedDate(),users.getUpdatedDate());
		
		
		
	}
	
	
}
