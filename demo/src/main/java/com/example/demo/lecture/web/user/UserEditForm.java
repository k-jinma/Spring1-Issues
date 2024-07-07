package com.example.demo.lecture.web.user;

import com.example.demo.lecture.entity.UserEntity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserEditForm {

  private String firstName;

  private String lastName;

  private String firstNameKana;

  private String lastNameKana;

  private int age;

  private String phoneNumber;

  private String postalCode;

  private String address;

  private String updatedAt;

  public void setEntity(UserEntity user) {
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
    this.firstNameKana = user.getFirstNameKana();
    this.lastNameKana = user.getLastNameKana();
    this.age = user.getAge();
    this.phoneNumber = user.getPhoneNumber();
    this.postalCode = user.getPostalCode();
    this.address = user.getAddress();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
      "yyyy-MM-dd'T'HH:mm:ss"
    );
    this.updatedAt = user.getUpdatedAt().format(formatter);
  }

  public void updateEntityAttributes(UserEntity user) {
    user.setFirstName(firstName);
    user.setFirstNameKana(firstNameKana);
    user.setLastname(lastName);
    user.setLastNameKana(lastNameKana);
    user.setAge(age);
    user.setPhoneNumber(phoneNumber);
    user.setPostalCode(postalCode);
    user.setAddress(address);
  }

  public LocalDateTime getUpdatedAtDateTime() {
    return LocalDateTime.parse(this.updatedAt);
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getLastNameKana() {
    return lastNameKana;
  }

  public void setLastNameKana(String lastNameKana) {
    this.lastNameKana = lastNameKana;
  }

  public String getFirstNameKana() {
    return firstNameKana;
  }

  public void setFirstNameKana(String firstNameKana) {
    this.firstNameKana = firstNameKana;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
}
