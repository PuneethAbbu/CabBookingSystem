package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Route;

@Repository
public interface RouteReposiroty extends JpaRepository<Route, Integer> {
	 @Query("SELECT route.distance FROM Route route WHERE route.fromLocation.id = :from_id AND route.toLocation.id = :to_id")
	 Optional<Integer> findDistance(@Param("from_id") int fromId, @Param("to_id") int toId);
}
