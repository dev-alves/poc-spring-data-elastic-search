package com.spring.elastic.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.elastic.domain.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}