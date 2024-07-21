package com.example.demo.lecture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.lecture.entity.ItemEntity;
import com.example.demo.lecture.repository.ItemRepository;
import com.example.demo.lecture.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Page<ItemEntity> findAll(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }


}
