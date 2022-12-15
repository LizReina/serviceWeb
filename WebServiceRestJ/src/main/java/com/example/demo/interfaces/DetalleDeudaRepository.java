package com.example.demo.interfaces;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.DetalleDeuda;

public interface DetalleDeudaRepository extends JpaRepository<DetalleDeuda,Integer>{
    
    @Query( "SELECT * FROM DetalleDeuda d  WHERE d.deuda_id = :deuda_id")
    List<DetalleDeuda> findDetalleByDeudaId(@Param("deuda_id") Integer deuda_id);
}
