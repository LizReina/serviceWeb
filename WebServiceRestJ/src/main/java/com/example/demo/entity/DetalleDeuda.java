package com.example.demo.entity;

import java.io.Serializable;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table(name="detalledeudas")
public class DetalleDeuda implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    float monto;

    @ManyToOne
    private Deuda deuda;

    @ManyToOne
    private ConceptoDeuda conceptodeuda;

    public DetalleDeuda() {
    }

    public DetalleDeuda(int id, float monto, Deuda deuda) {
        this.id = id;
        this.monto = monto;
        this.deuda = deuda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Deuda getDeuda() {
        return deuda;
    }

    public void setDeuda(Deuda deuda) {
        this.deuda = deuda;
    }

    public ConceptoDeuda getConceptodeuda() {
        return conceptodeuda;
    }

    public void setConceptodeuda(ConceptoDeuda conceptodeuda) {
        this.conceptodeuda = conceptodeuda;
    }

    
}
