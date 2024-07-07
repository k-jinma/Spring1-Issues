package com.example.demo.lecture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.lecture.entity.CustomerEntity;
import com.example.demo.lecture.entity.UserEntity;
import com.example.demo.lecture.repository.CustomerRepository;
import com.example.demo.lecture.service.CustomerService;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<CustomerEntity> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public CustomerEntity findOne(Integer id) throws NotFoundException {
        Optional<CustomerEntity> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new NotFoundException();
        }
        return customer.get();   }

}
