package com.example.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.Citizen;
import com.example.repo.CitizenRepo;

@Service
public class CitizenService {

	@Autowired
	CitizenRepo repo;
	
	public Citizen postCitizen(Citizen citizen) {
		citizen.setAadhaarNo("0");
		citizen.setApplicationDate(new Date());
		citizen.setIssueDate(new Date());
		citizen.setIsDeleted(false);
		citizen.setDuplicate(false);
		citizen.setApprovalStatus("Not Applied");
		
		return repo.save(citizen);
	}
	
	public List<Citizen> getAllCitizens(){
		return repo.findAll();
	}
	
	public Citizen getCitizen(String cID) {
		return repo.findBycID(cID);
	}
	
	public Optional<Citizen> getCitizenbyID(Integer id) {
		return repo.findById(id);
	}
	
	public List<Citizen> getCurrentCitizen(Boolean isDeleted){
		return repo.getCurrenctCitizen(isDeleted);
	}
	
	public List<Citizen> getNewAadhaarIssue(){
		return repo.getNewAadhaarCitizen("Applied");
	}
	
	public List<Citizen> updateCitizen(Integer id,Citizen citizen){
		Citizen newCitizen=repo.findById(id).orElse(null);
		newCitizen.setName(citizen.getName());
		newCitizen.setDob(citizen.getDob());
		newCitizen.setAddress(citizen.getAddress());
		newCitizen.setEmail(citizen.getEmail());
		newCitizen.setGender(citizen.getGender());
		newCitizen.setMobileNo(citizen.getMobileNo());
		newCitizen.setCitizenId(citizen.getCitizenId());
		newCitizen.setPassportNo(citizen.getPassportNo());
		repo.save(newCitizen);
		return repo.findAll();
		
	}
	
	public List<Citizen> deleteUpdate(Integer id) {
		Citizen existingCitizen=repo.findById(id).orElse(null);
		if(existingCitizen!=null) {
				existingCitizen.setIsDeleted(true);
				repo.save(existingCitizen);
				return repo.findAll();

		}
		return null;
	}
	
	public List<Citizen> updateIssude(Integer id){
		Citizen existingCitizen=repo.findById(id).orElse(null);
		if(existingCitizen!=null) {
				existingCitizen.setApprovalStatus("Issued");;
				repo.save(existingCitizen);
				return repo.findAll();

		}
		return null;
	}
	
	public List<Citizen> duplicateUpdate(Integer id){
		Citizen existingCitizen=repo.findById(id).orElse(null);
		if(existingCitizen!=null) {
			existingCitizen.setDuplicate(true);
			repo.save(existingCitizen);
			return repo.findAll();
		}
		return null;
	}
	
	public List<Citizen> applicationUpdate(Integer id){
		Citizen existingCitizen=repo.findById(id).orElse(null);
		if(existingCitizen!=null) {
				existingCitizen.setApprovalStatus("Applied");
				existingCitizen.setApplicationDate(new Date());
				Calendar calendar = Calendar.getInstance();
		        calendar.setTime(existingCitizen.getApplicationDate());
		        calendar.add(Calendar.DAY_OF_MONTH, 7);
		        existingCitizen.setIssueDate(calendar.getTime());
				Random random = new Random();
				StringBuilder aadhaarNoBuilder = new StringBuilder();

				aadhaarNoBuilder.append(random.nextInt(9) + 1);

				for (int i = 1; i < 12; i++) {
				    aadhaarNoBuilder.append(random.nextInt(10));
				}

				String generatedAadhaarNo = aadhaarNoBuilder.toString();
				existingCitizen.setAadhaarNo(generatedAadhaarNo);
				repo.save(existingCitizen);
				return repo.findAll();

		}
		return null;
	}
	
	public void deleteCitizen(Integer id) {
		repo.deleteById(id);
	}
}
