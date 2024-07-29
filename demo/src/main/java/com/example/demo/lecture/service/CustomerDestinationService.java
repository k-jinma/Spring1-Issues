package com.example.demo.lecture.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.lecture.entity.CustomerDestinationEntity;

public interface CustomerDestinationService {

    Page<CustomerDestinationEntity> findAll(Pageable pageable);
}
