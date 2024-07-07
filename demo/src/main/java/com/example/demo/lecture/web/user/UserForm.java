package com.example.demo.lecture.web.user;

import com.example.demo.lecture.entity.UserEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserForm {

  @NotEmpty(message = "{validation.field.required}")
  private String firstName;

  @NotEmpty(message = "{validation.field.required}")
  private String lastName;

  @NotEmpty(message = "{validation.field.required}")
  private String firstNameKana;

  @NotEmpty(message = "{validation.field.required}")
  private String lastNameKana;

  @NotNull(message = "{validation.field.required}")
  @Min(value = 0)
  @Max(value = 100)
  private Integer age;

  @NotEmpty(message = "{validation.field.required}")
  @Pattern(regexp = "[0-9-]+", message = "{validation.numerichyphen}")
  @Pattern(
    regexp = "\\d{2,3}-\\d{4}-\\d{4}",
    message = "{validation.field.phonenumber}"
  )
  private String phoneNumber;

  @NotEmpty(message = "{validation.field.required}")
  @Pattern(regexp = "[0-9-]+", message = "{validation.numerichyphen}")
  @Pattern(regexp = "\\d{3}-\\d{4}", message = "{validation.field.postalcode}")
  private String postalCode;

  @NotEmpty(message = "{validation.field.required}")
  private String address;

  public UserEntity toEntity() {
    UserEntity user = new UserEntity();
    user.setFirstName(firstName);
    user.setFirstNameKana(firstNameKana);
    user.setLastname(lastName);
    user.setLastNameKana(lastNameKana);
    user.setAge(age);
    user.setPhoneNumber(phoneNumber);
    user.setPostalCode(postalCode);
    user.setAddress(address);
    return user;
  }

  // 以降 getter,setterのみ

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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getlastNameKana() {
    return lastNameKana;
  }

  public void setlastNameKana(String lastNameKana) {
    this.lastNameKana = lastNameKana;
  }

  public String getfirstNameKana() {
    return firstNameKana;
  }

  public void setfirstNameKana(String firstNameKana) {
    this.firstNameKana = firstNameKana;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
