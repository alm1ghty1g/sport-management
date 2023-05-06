package com.example.sportmanagementsystem.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Organization {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String organizationName;


    @OneToMany(mappedBy = "organization")
    private List<Participant> participantList;


    @OneToMany(mappedBy = "organization")
    private List<Reward> rewardList;


    @OneToOne
    private SportEvent sportEvent;
}
