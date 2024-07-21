package com.example.demo.lecture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.lecture.entity.InboundHistoryEntity;
import com.example.demo.lecture.repository.InboundHistoryRepository;
import com.example.demo.lecture.service.InboundService;

@Service
public class InboundServiceImpl implements InboundService {

    @Autowired
    InboundHistoryRepository inboundHistoryRepository;

    @Override
    public InboundHistoryEntity save(InboundHistoryEntity inboundHistoryEntity) {
        return inboundHistoryRepository.save(inboundHistoryEntity);
    }

}