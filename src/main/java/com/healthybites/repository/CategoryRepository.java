package com.healthybites.repository;

import com.healthybites.model.entity.RegistroProgreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<RegistroProgreso,Integer> {

}