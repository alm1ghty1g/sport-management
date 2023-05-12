package com.example.sportmanagementsystem.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    private String password;

    private String roles;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<SportEvent> eventList;
}
