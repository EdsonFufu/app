package com.example.test.app.controllers;

import com.example.test.app.models.Agent;
import com.example.test.app.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AgentController {
    @Autowired
    private AgentRepository agentRepository;
    @PostMapping("/agent/add")
    public ResponseEntity<Agent> addAgent(@RequestBody Agent agent){
        return ResponseEntity.ok(agentRepository.save(agent));
    }
    @GetMapping("/agent/{id}")
    public ResponseEntity<Agent> getAgent(@PathVariable Long id){
        return ResponseEntity.ok(agentRepository.findById(id).orElse(null));
    }
    @GetMapping("/agent/")
    public ResponseEntity<List<Agent>> getAgents(){
        return ResponseEntity.ok(agentRepository.findAll());
    }
}
