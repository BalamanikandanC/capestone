package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Admin;
import com.example.service.AdminService;

@RestController
@CrossOrigin(origins="*")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/admin")
	public Admin saveAdmin(@RequestBody Admin admin) {
		return adminService.postAdminCredentials(admin);
	}
	
	@GetMapping("/findByemail/{email}")
	public Admin findAdmin(@PathVariable String email) {
		return adminService.getAdminCredentials(email);
	}

}
