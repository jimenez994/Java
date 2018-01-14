package com.zeus.relationships.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zeus.relationships.models.License;
import com.zeus.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public ArrayList<License> getAll(){
		return licenseRepository.findAll();
	}
	
	public License getLicense(Long id) {
		return licenseRepository.findOne(id);
	}
	
	@Transactional
	public void addLicense(License license) {
		Long personId = license.getPerson().getId();
		String licenseNumber = String.format("%06d", personId);
		license.setNumber(licenseNumber);
		licenseRepository.save(license);
	}

}
