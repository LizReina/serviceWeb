package com.example.demo.interfaces;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.cliente;


@Repository
public interface ClienteRepository extends JpaRepository<cliente,Integer>{

}
