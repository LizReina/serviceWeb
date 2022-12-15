package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Deuda;
import com.example.demo.interfaces.DeudaRepository;



@RestController
@RequestMapping(path="/deuda")
public class DeudaController {
    @Autowired
    private DeudaRepository repo;

    @ResponseBody
    @PostMapping(value = "/add", consumes = {"application/json"})
    public Deuda add(@RequestBody Deuda val){ 
        return repo.save(val);
    }

    @GetMapping("/views")
    public List<Deuda> views(){
        return repo.findAll();
    }
    
    @GetMapping("/views/{val}")
    public Optional<Deuda> views(@PathVariable Integer val){
        return repo.findById(val);
       //return repo.findByDeudaId(val);

    }

     @GetMapping("/viewsDeuda/{val}")
    public List<Deuda> viewsCli(@PathVariable Integer val){
        return repo.findDeudasByClienteId(val);
       //return repo.findByDeudaId(val);

    }
    
    
    @PutMapping("/update")
    public Deuda views(@RequestBody Deuda val){
        return repo.save(val);
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id){
       
       // repo.updateDeudaByEstado(id,true);
         return "Id: " + id + "update";
    }
    
    @DeleteMapping("/delete/{val}")
    public String delete(@PathVariable Integer val){
        
        repo.deleteById(val);
        return "Id: " + val + "delete";
    }
}
