package com.example.demo.lecture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.lecture.entity.OutboundHistoryEntity;
import com.example.demo.lecture.repository.OutboundHistoryRepository;
import com.example.demo.lecture.service.OutboundService;

@Service
public class OutboundServiceImpl implements OutboundService{

    @Autowired
    OutboundHistoryRepository outboundHistoryRepository;

    @Override
    public OutboundHistoryEntity save(OutboundHistoryEntity outboundHistoryEntity) {
        return outboundHistoryRepository.save(outboundHistoryEntity);
    }

}
