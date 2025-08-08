package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CabType;
import com.service.CabTypeService;

@RestController
@RequestMapping(value = "cabTypes")
public class CabTypeController {
    @Autowired
    private CabTypeService cabTypeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CabType> getAllCabTypes() {
    	System.out.println(cabTypeService.getAllCabTypes());
        return cabTypeService.getAllCabTypes();
    }

    @GetMapping("/multiplier/{id}")
    public double getMultiplier(@PathVariable int id) {
        return cabTypeService.getMultiplierById(id);
    }
}
