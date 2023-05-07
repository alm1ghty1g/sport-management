package com.example.sportmanagementsystem.service;


import com.example.sportmanagementsystem.model.Organization;
import com.example.sportmanagementsystem.model.SportEvent;
import com.example.sportmanagementsystem.repository.EventRepository;
import com.example.sportmanagementsystem.repository.OrganizationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventService {


    private final EventRepository eventRepository;

    private final OrganizationRepository organizationRepository;

    public EventService(EventRepository eventRepository, OrganizationRepository organizationRepository) {
        this.eventRepository = eventRepository;
        this.organizationRepository = organizationRepository;
    }

    public List<SportEvent> retrieveAllEvents() {
        return eventRepository.findAll();
    }

    public SportEvent findById(int id) {
        return eventRepository.findById(id);
    }

    public void deleteById(int id) {
        SportEvent event = findById(id);
        if (event != null) {
            Organization organization = event.getOrganization();
            organization.setSportEvent(null);
            organizationRepository.save(organization);
            eventRepository.deleteById(id);
        }
    }


    public SportEvent patchById(int id, SportEvent updateEvent) {
        SportEvent event = findById(id);
        event.setEventName(updateEvent.getEventName());
        event.setOrganization(updateEvent.getOrganization());
        event.setReward(updateEvent.getReward());
        return eventRepository.save(event);
    }


    public SportEvent createEvent(SportEvent createSportEvent) {
        return eventRepository.save(createSportEvent);
    }

}
