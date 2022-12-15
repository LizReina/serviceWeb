package com.example.demo.entity;



import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;



/**
 *
 * @author bismart
 */

@Entity
@Table(name="clientes")
public class cliente implements Serializable{
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nombre;
    String correo;
    String password;

   // @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "deuda")
   // @OneToMany(mappedBy = "cliente")
    //private List<Deuda> deuda;

    @OneToMany(mappedBy = "cliente")
    private List<Deuda> deuda;


    public cliente() {
        super();
    }

    public cliente(int id, String nombre, String correo, String password) {
        this.id=id;
        this.nombre = nombre;
        this.correo = correo;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    
}
