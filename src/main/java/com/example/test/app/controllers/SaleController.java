package com.example.test.app.controllers;

import com.example.test.app.models.Agent;
import com.example.test.app.models.Sale;
import com.example.test.app.repository.AgentRepository;
import com.example.test.app.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SaleController {
    @Autowired
    private SaleRepository saleRepository;
    @PostMapping("/sale/add")
    public ResponseEntity<Sale> addSale(@RequestBody Sale sale){
        return ResponseEntity.ok(saleRepository.save(sale));
    }
    @GetMapping("/sale/{id}")
    public ResponseEntity<Sale> getSale(@PathVariable Long id){
        return ResponseEntity.ok(saleRepository.findById(id).orElse(null));
    }
    @GetMapping("/sale/")
    public ResponseEntity<List<Sale>> getSales(){
        return ResponseEntity.ok(saleRepository.findAll());
    }
}
