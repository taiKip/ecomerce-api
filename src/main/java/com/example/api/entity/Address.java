package com.example.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String building;
    @Column(name = "house")
    private String houseNumber;
    private String city;
    private String zip;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
