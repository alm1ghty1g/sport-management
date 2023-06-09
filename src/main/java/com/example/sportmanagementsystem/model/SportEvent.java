package com.example.sportmanagementsystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SportEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String eventName;

    private String reward;

    private LocalDate eventDate;

    @OneToOne(mappedBy = "sportEvent")
    @JsonIgnore
    private Organization organization;

    @ManyToOne
    @JsonIgnore
    private User user;



}
