package com.example.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Pago;

public interface PagoRepository extends JpaRepository<Pago,Integer>{
    
}
