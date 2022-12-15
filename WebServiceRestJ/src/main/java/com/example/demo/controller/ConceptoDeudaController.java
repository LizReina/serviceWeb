package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.entity.ConceptoDeuda;
import com.example.demo.interfaces.ConceptoDeudaRepository;

@RestController
@RequestMapping(path="/conceptodeuda")
public class ConceptoDeudaController {
    @Autowired
    private ConceptoDeudaRepository repo;

    @ResponseBody
    @PostMapping(value = "/add", consumes = {"application/json"})
    public ConceptoDeuda add(@RequestBody ConceptoDeuda val){
        return repo.save(val);
    }

    @GetMapping("/views")
    public List<ConceptoDeuda> views(){
        return repo.findAll();
    }
}
