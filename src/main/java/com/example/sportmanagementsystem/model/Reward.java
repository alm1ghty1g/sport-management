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
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String rewardName;

    @ManyToOne
    @JsonIgnore
    private Organization organization;

//    @OneToOne
//    @JsonIgnore
//    private SportEvent sportEvent;
}
