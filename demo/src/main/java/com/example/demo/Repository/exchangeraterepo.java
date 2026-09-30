package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.exchangerate;

public interface exchangeraterepo extends JpaRepository<exchangerate, Integer> {

}
