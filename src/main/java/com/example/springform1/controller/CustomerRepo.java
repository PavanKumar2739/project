package com.example.springform1.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springform1.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
