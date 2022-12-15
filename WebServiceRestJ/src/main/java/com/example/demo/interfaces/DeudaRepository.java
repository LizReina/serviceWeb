package com.example.demo.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Deuda;


@Repository
public interface DeudaRepository extends JpaRepository<Deuda,Integer>{
   
@Query( "SELECT * FROM Deuda d  WHERE d.estado = false AND d.cliente_id = :cliente_id")
 List<Deuda> findDeudasByClienteId(@Param("cliente_id") Integer cliente_id);

/*  @Query( "SELECT * FROM Deuda d  WHERE d.cliente_id = :cliente_id and d.estado=true")
 List<Deuda> findDeudasByinfoId(@Param("cliente_id") Integer cliente_id);
 */
/* @Transactional 
@Modifying
@Query("update Deuda d set d.estado = :estado WHERE d.id = :id")
void updateDeudaByEstado(@Param("id") Integer id, @Param("estado") boolean estado); */
}
