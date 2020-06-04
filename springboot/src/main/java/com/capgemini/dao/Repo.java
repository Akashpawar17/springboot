package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Alien;

import antlr.collections.List;

public interface Repo extends JpaRepository<Alien, Integer> {
	java.util.List<Alien> findByAidGreaterThan(int aid);

}
