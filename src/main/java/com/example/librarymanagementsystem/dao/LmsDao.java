package com.example.librarymanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.librarymanagementsystem.entity.LmsEntity;

@Repository
public interface LmsDao extends JpaRepository<LmsEntity, Long>{

}
