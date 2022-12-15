package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="conceptodeudas")
public class ConceptoDeuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String descripcion;

 
    @OneToMany(mappedBy = "conceptodeuda")
    private List<DetalleDeuda> detalleDeuda;


    
    public ConceptoDeuda() {
    }


    public ConceptoDeuda(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


 
}
