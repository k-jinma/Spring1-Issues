package com.example.demo.lecture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.lecture.entity.CustomerDestinationEntity;
import com.example.demo.lecture.repository.CustomerDestinationRepository;
import com.example.demo.lecture.service.CustomerDestinationService;

@Service
public class CustomerDestinationServiceImpl implements CustomerDestinationService{

    @Autowired
    CustomerDestinationRepository customerDestinationRepository;

    @Override
    public Page<CustomerDestinationEntity> findAll(Pageable pageable) {
        return customerDestinationRepository.findAll(pageable);
    }

}
