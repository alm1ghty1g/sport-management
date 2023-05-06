package com.example.sportmanagementsystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SportEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String eventName;

    @OneToOne(mappedBy = "sportEvent")
    @JsonIgnore
    private Organization organization;


    @OneToOne
    @JsonIgnore
    private Reward reward;

}
