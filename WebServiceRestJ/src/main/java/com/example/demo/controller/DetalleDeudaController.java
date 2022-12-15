package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DetalleDeuda;
import com.example.demo.interfaces.DetalleDeudaRepository;


@RestController
@RequestMapping(path="/detalledeuda")
public class DetalleDeudaController {
    @Autowired
    private DetalleDeudaRepository repo;

    @ResponseBody
    @PostMapping(value = "/add", consumes = {"application/json"})
    public DetalleDeuda add(@RequestBody DetalleDeuda val){
        return repo.save(val);
    }
   
    @GetMapping("/views")
    public List<DetalleDeuda> views(){
        return repo.findAll();
    }
 
    @GetMapping("/views/{val}")
    public Optional<DetalleDeuda> views(@PathVariable Integer val){
        return repo.findById(val);
    }
  
    @GetMapping("/viewsDetalle/{val}")
    public List<DetalleDeuda> viewsCli(@PathVariable Integer val){
        return repo.findDetalleByDeudaId(val);
       //return repo.findByDeudaId(val);

    }
    
}
