package com.example.test.app.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CONTACT")
public class Contact {
    @Column(name = "ID") @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
    @Column(name = "EMAIL") private String email;
    @Column(name = "MOBILE") private String mobile;

    @Override
    @SneakyThrows(value = JsonProcessingException.class)
    public String toString() {
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}
