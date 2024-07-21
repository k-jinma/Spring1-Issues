package com.example.demo.lecture.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.lecture.entity.ItemEntity;

public interface ItemService {
    Page<ItemEntity> findAll(Pageable pageable);
}
