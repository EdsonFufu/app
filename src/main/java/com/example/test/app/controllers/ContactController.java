package com.example.test.app.controllers;

import com.example.test.app.models.Agent;
import com.example.test.app.models.Contact;
import com.example.test.app.repository.AgentRepository;
import com.example.test.app.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;
    @PostMapping("/contact/add")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
        return ResponseEntity.ok(contactRepository.save(contact));
    }
    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id){
        return ResponseEntity.ok(contactRepository.findById(id).orElse(null));
    }
    @GetMapping("/contact/")
    public ResponseEntity<List<Contact>> getContacts(){
        return ResponseEntity.ok(contactRepository.findAll());
    }
}
