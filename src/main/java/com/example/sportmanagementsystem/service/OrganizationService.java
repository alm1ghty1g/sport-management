package com.example.sportmanagementsystem.service;

import com.example.sportmanagementsystem.model.Organization;
import com.example.sportmanagementsystem.model.Participant;
import com.example.sportmanagementsystem.model.SportEvent;
import com.example.sportmanagementsystem.repository.EventRepository;
import com.example.sportmanagementsystem.repository.OrganizationRepository;
import com.example.sportmanagementsystem.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizationService {


    private final OrganizationRepository organizationRepository;

    private final ParticipantRepository participantRepository;

    private final EventRepository eventRepository;


    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository, ParticipantRepository participantRepository, EventRepository eventRepository) {
        this.organizationRepository = organizationRepository;
        this.participantRepository = participantRepository;
        this.eventRepository = eventRepository;
    }

    public List<Organization> retrieveAllOrganizations() {
        return organizationRepository.findAll();
    }

    public Organization findById(int id) {
        return organizationRepository.findById(id);
    }

    public void deleteById(int id) {
        Organization organization = findById(id);
        if (organization != null) {
            List<Participant> participantList = organization.getParticipantList();
            for (Participant participant : participantList) {
                participant.setOrganization(null);
                participantRepository.save(participant);
            }
            SportEvent event = organization.getSportEvent();
            event.setOrganization(null);
            eventRepository.save(event);
            organizationRepository.deleteById(id);
        }
    }

    public Organization patchById(int id, Organization updateUser) {
        Organization organization = findById(id);
        organization.setOrganizationName(updateUser.getOrganizationName());
        return organizationRepository.save(organization);
    }


    public Organization createOrganization(Organization createUserRequest) {
        return organizationRepository.save(createUserRequest);
    }
}
