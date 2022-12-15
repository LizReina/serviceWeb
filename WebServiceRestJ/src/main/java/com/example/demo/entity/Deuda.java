package com.example.demo.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author bismart
 */

@Entity
@Table(name="deudas")
public class Deuda implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String fechaCreacion;
    String fechaVencimiento;
    float total;
    boolean estado;
   // int idCliente;

   @ManyToOne
    private cliente cliente;

    @OneToMany(mappedBy = "deuda")
    private List<DetalleDeuda> detalleDeuda;


    @OneToMany(mappedBy = "deuda")
    private List<Pago> pago;


    public Deuda() {
    }

    public Deuda(int id, String fechaCreacion, String fechaVencimiento, float total,boolean estado, cliente cliente) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.fechaVencimiento = fechaVencimiento;
        this.total = total;
        this.estado=estado;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

   
    public void setId(int id) {
        this.id = id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

 
}
