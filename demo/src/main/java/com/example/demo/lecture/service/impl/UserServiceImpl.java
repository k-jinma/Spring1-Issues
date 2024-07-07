package com.example.demo.lecture.service.impl;

import com.example.demo.lecture.entity.UserEntity;
import com.example.demo.lecture.repository.UserRepository;
import com.example.demo.lecture.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  @Override
  public UserEntity save(UserEntity user) {
    return userRepository.save(user);
  }

  @Override
  public void delete(UserEntity user) {
    userRepository.delete(user);
  }

  @Override
  public UserEntity findOne(Long id) throws NotFoundException {
    Optional<UserEntity> user = userRepository.findById(id);
    if (!user.isPresent()) {
      throw new NotFoundException();
    }
    return user.get();
  }

  @Override
  public Page<UserEntity> findAll(Pageable pageable) {
    return userRepository.findAll(pageable);
  }
}
