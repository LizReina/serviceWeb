package com.example.demo.controller;



import com.example.demo.entity.cliente;
import com.example.demo.interfaces.ClienteRepository;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/cliente")
public class clienteController {
    @Autowired
    private ClienteRepository repo;

    @ResponseBody
    @PostMapping(value = "/add", consumes = {"application/json"})
    public cliente add(@RequestBody cliente val){
        return repo.save(val);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/views")
    public List<cliente> views(){
        return repo.findAll();
    }
    
    @GetMapping("/views/{val}")
    public Optional<cliente> views(@PathVariable Integer val){
        return repo.findById(val);
    }
    
    @PutMapping("/update")
    public cliente views(@RequestBody cliente val){
        return repo.save(val);
    }
    
    @DeleteMapping("/delete/{val}")
    public String delete(@PathVariable Integer val){
        repo.deleteById(val);
        return "Id: " + val + "delete";
    }
}
