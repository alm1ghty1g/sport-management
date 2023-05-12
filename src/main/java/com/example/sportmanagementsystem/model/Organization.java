package com.example.sportmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @JsonIgnore
    private List<Participant> participantList;

    @OneToOne
    @JsonIgnore
    private SportEvent sportEvent;
}
