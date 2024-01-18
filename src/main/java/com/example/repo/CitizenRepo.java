package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.pojo.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {


	String query="select citizen from Citizen citizen where citizen.citizenId=?1";
	@Query(query)
	public Citizen findBycID(String cID);
	
	String query1="select citizen from Citizen citizen where citizen.isDeleted=?1";
	@Query(query1)
	public List<Citizen> getCurrenctCitizen(Boolean isDeleted);
	
	String query2="select citizen from Citizen citizen where citizen.approvalStatus=?1";
	@Query(query2)
	public List<Citizen> getNewAadhaarCitizen(String status);
}
