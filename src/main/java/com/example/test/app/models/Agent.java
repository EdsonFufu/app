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
@Table(name = "AGENT")
public class Agent {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;

    @Column(name = "FULL_NAME") private String fullName;
    @Column(name = "DATE-OF_BIRTH") private String dateOfBirth;
    @Column(name = "CONTACT") private Long contactId;
    @Column(name = "SERVICE_TYE") private String serviceType;
    @Column(name = "COMMISSION_ACCOUNT") private String commissionAccount;
    @Column(name = "COMMISSION_AMOUNT") private String commissionAmount;


    @Override
    @SneakyThrows(value = JsonProcessingException.class)
    public String toString() {
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}
