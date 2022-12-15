package com.example.demo.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Pago;
import com.example.demo.interfaces.PagoRepository;


@RestController
@RequestMapping(path="/pago")
public class PagoController {
    @Autowired
    private PagoRepository repo;

    @ResponseBody
    @PostMapping(value = "/add", consumes = {"application/json"})
    public Pago add(@RequestBody Pago val){

        
        return repo.save(val);
    }

    @GetMapping("/views")
    public List<Pago> views(){
        return repo.findAll();
    }

    @PutMapping("/update")
    public Pago views(@RequestBody Pago val){
        return repo.save(val);
    }
    @DeleteMapping("/delete/{val}")
    public String delete(@PathVariable Integer val){
        repo.deleteById(val);
        return "Id: " + val + "delete";
    }
}
