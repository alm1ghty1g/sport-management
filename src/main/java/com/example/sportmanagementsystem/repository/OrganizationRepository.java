package com.example.sportmanagementsystem.repository;

import com.example.sportmanagementsystem.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {


    Organization findById(int id);

}
