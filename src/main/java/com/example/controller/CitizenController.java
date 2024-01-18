package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Citizen;
import com.example.service.CitizenService;

@RestController
@CrossOrigin(origins="*")
public class CitizenController {

	@Autowired
	CitizenService citizenService;
	
	@PostMapping("/citizen")
	public Citizen saveCitizen(@RequestBody Citizen citizen)
	{
		return citizenService.postCitizen(citizen);
	}
	
	@GetMapping("/getAllCitizens")
	public List<Citizen> getAllCitizens(){
		return citizenService.getAllCitizens();
	}
	
	@GetMapping("/getCitizenBycID/{cID}")
	public Citizen getCitizenBycID(@PathVariable String cID) {
		return citizenService.getCitizen(cID);
	}
	
	@GetMapping("/getCitizenByID/{id}")
	public Optional<Citizen> getCitizenByID(@PathVariable Integer id) {
		return citizenService.getCitizenbyID(id);
	}
	
	@GetMapping("/getCurrentCitizen/{isDeleted}")
	public List<Citizen> getCurrentCitizen(@PathVariable Boolean isDeleted ){
		return citizenService.getCurrentCitizen(isDeleted);
	}
	
	@GetMapping("/getNewAadhaarIssue")
	public List<Citizen> getNewAadhaarIssue(){
		return citizenService.getNewAadhaarIssue();
	}
	@DeleteMapping("/deleteCitizen/{id}")
	public void deleteCitizen(@PathVariable Integer id) {
		citizenService.deleteCitizen(id);
	}
	
	@PutMapping("/updateDelete/{id}")
	public List<Citizen> updateDelete(@PathVariable Integer id) {
		return citizenService.deleteUpdate(id);
	}
	
	@PutMapping("/updateIssued/{id}")
	public List<Citizen> updateIssued(@PathVariable Integer id){
		return citizenService.updateIssude(id);
	}
	
	@PutMapping("/updateApplication/{id}")
	public List<Citizen> updateApplication(@PathVariable Integer id){
		return citizenService.applicationUpdate(id);
	}
	
	@PutMapping("/updateDuplicate/{id}")
	public List<Citizen> updateDuplicate(@PathVariable Integer id){
		return citizenService.duplicateUpdate(id);
	}
	
	@PutMapping("/updateCitizen/{id}")
	public List<Citizen> updateCitizen(@PathVariable Integer id, @RequestBody Citizen citizen){
		System.out.println(citizen.getName());
		return citizenService.updateCitizen(id,citizen);
	}
}
