package com.example.demo.lecture.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

  @CreatedBy
  @Column(name = "created_by")
  private String CreatedBy;

  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime CreatedAt;

  @LastModifiedBy
  @Column(name = "updated_by")
  private String UpdatedBy;

  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime UpdatedAt;

  public LocalDateTime getUpdatedAt() {
    return UpdatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    UpdatedAt = updatedAt;
  }

  public String getUpdatedBy() {
    return UpdatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    UpdatedBy = updatedBy;
  }

  public LocalDateTime getCreatedAt() {
    return CreatedAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    CreatedAt = createdAt;
  }

  public String getCreatedBy() {
    return CreatedBy;
  }

  public void setCreatedBy(String createdBy) {
    CreatedBy = createdBy;
  }
}
