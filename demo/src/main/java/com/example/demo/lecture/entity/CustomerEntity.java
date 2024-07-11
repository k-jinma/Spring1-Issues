package com.example.demo.lecture.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class CustomerEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phone_number;

    //リレーションの関係を定義する
    @OneToMany(mappedBy = "customer")
    private List<CustomerDestinationEntity> customerDestinations;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPostal_code() {
        return postal_code;
    }
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public List<CustomerDestinationEntity> getCustomerDestinations() {
        return customerDestinations;
    }
    public void setCustomerDestinations(List<CustomerDestinationEntity> customerDestinations) {
        this.customerDestinations = customerDestinations;
    }

}
