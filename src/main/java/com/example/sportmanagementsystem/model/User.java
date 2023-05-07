package com.example.sportmanagementsystem.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "user_details")
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<SportEvent> eventList;
}
