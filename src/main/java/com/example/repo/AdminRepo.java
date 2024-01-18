package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.pojo.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	
	String query="select admin from Admin admin where admin.email=?1";
	@Query(query)
	public Admin findByemail(String email);

}
