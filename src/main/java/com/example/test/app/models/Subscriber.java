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
@Table(name = "SUBSCRIBER")
public class Subscriber {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;

    @Column(name = "FULL_NAME") private String fullName;
    @Column(name = "DATE_OF_BIRTH") private String dateOfBirth;
    @Column(name = "CONTACT") private Long contactId;
    @Column(name = "SERVICE_TYPE") private String serviceType;
    @Column(name = "AGENT_CODE") private String agentCode;


    @Override
    @SneakyThrows(value = JsonProcessingException.class)
    public String toString() {
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}

/*
{
    "fullName": "Vivian Edson",
    "dateOfBirth": "2013-01-15",
    "contactId": "3",
    "serviceType": "Service1",
    "agentCode": "1"
}
 */