package com.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.CabTypeService;

@SpringBootTest
class CabTypeControllerTest {
	@Autowired
	CabTypeService cabTypeService;

	@Test
	void testGetAllCabTypes() {
//		fail("Not yet implemented");
		int size = cabTypeService.getAllCabTypes().size();
		assertEquals(3, size);
	}

	@Test
	void testGetMultiplier() {
//		fail("Not yet implemented");
		double multiplier = cabTypeService.getMultiplierById(1);
		assertEquals(1.0, multiplier);
	}

}
