package com.example.demo.lecture.service;

import com.example.demo.lecture.entity.UserEntity;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
  UserEntity save(UserEntity user);

  void delete(UserEntity user);

  UserEntity findOne(Long id) throws NotFoundException;

  Page<UserEntity> findAll(Pageable pageable);
}
