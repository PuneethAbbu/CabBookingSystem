package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CabType;
import com.repository.CabTypeRepository;

@Service
public class CabTypeService {
	@Autowired
	CabTypeRepository cabTypeRepository;

	public List<CabType> getAllCabTypes() {
		return cabTypeRepository.findAll();
	}
	
	public double getMultiplierById(int id) {
		return cabTypeRepository.getMultiplierById(id).get();
	}
}
