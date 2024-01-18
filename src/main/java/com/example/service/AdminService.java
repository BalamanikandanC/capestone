package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.Admin;
import com.example.repo.AdminRepo;

@Service
public class AdminService {

	@Autowired
	AdminRepo repo;
	
	public Admin getAdminCredentials(String email) {
		return repo.findByemail(email);
	}
	
	public Admin postAdminCredentials(Admin admin) {
		return repo.save(admin);
	}
	
}
