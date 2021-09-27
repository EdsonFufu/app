package com.example.test.app.controllers;

import com.example.test.app.models.Agent;
import com.example.test.app.models.Subscriber;
import com.example.test.app.repository.AgentRepository;
import com.example.test.app.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SubscriberController {
    @Autowired
    private SubscriberRepository subscriberRepository;
    @PostMapping("/subscriber/add")
    public ResponseEntity<Subscriber> addSubscriber(@RequestBody Subscriber subscriber){
        return ResponseEntity.ok(subscriberRepository.save(subscriber));
    }
    @GetMapping("/subscriber/{id}")
    public ResponseEntity<Subscriber> getSubscriber(@PathVariable Long id){
        return ResponseEntity.ok(subscriberRepository.findById(id).orElse(null));
    }
    @GetMapping("/subscriber/")
    public ResponseEntity<List<Subscriber>> getSubscribers(){
        return ResponseEntity.ok(subscriberRepository.findAll());
    }
}
