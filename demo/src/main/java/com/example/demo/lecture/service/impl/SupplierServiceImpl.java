package com.example.demo.lecture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.lecture.entity.SupplierEntity;
import com.example.demo.lecture.repository.SupplierRepositoty;
import com.example.demo.lecture.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    SupplierRepositoty supplierRepositoty;

    @Override
    public Page<SupplierEntity> findAll(Pageable pageable) {
        return supplierRepositoty.findAll(pageable);
    }

}
