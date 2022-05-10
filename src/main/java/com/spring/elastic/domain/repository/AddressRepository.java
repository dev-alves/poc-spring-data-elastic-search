package com.spring.elastic.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.elastic.domain.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}