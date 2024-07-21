package com.example.demo.lecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.lecture.entity.SupplierEntity;

@Repository
public interface SupplierRepositoty extends JpaRepository<SupplierEntity, Integer> {}
