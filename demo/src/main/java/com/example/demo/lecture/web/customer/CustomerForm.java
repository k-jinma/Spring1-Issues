package com.example.demo.lecture.web.customer;

import com.example.demo.lecture.entity.CustomerEntity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class CustomerForm {
    
    // 顧客名
    @NotEmpty(message = "{validation.field.required}")
    private String name;

    // 郵便番号
    @NotEmpty(message = "{validation.field.required}")
    @Pattern(regexp = "[0-9-]+", message = "{validation.numerichyphen}")
    @Pattern(regexp = "\\d{3}-\\d{4}", message = "{validation.field.postalcode}")
    private String postalCode;
    
    // 住所
    @NotEmpty(message = "{validation.field.required}")
    private String address;

    // 電話番号
    @NotEmpty(message = "{validation.field.required}")
    @Pattern(regexp = "[0-9-]+", message = "{validation.numerichyphen}")
    @Pattern(
      regexp = "\\d{2,3}-\\d{4}-\\d{4}",
      message = "{validation.field.phonenumber}"
    )
    private String phoneNumber;

    // CustomerFormをCustomerEntityに変換するメソッド
    // 事前にバリデーションを行うため、CustomerFormにはバリデーションを行うアノテーションを付与している
    public CustomerEntity toEntity(){
        CustomerEntity customer = new CustomerEntity();
        customer.setName(name);
        customer.setPostalCode(postalCode);
        customer.setAddress(address);
        customer.setPhoneNumber(phoneNumber);
        return customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
}
