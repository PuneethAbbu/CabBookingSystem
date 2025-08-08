package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.CabType;

@Repository
public interface CabTypeRepository extends JpaRepository<CabType, Integer> {
    @Query("SELECT c.multiplier FROM CabType c WHERE c.id = :id")
    public Optional<Double> getMultiplierById(@Param("id") int id);
}
