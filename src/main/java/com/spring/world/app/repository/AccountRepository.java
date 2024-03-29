package com.spring.world.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.world.app.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
