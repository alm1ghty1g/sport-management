package com.example.sportmanagementsystem.service;

import com.example.sportmanagementsystem.model.Participant;
import com.example.sportmanagementsystem.repository.ParticipantRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParticipantService {


    private final ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public List<Participant> retrieveAllParticipants() {
        return participantRepository.findAll();
    }

    public Participant findById(int id) {
        return participantRepository.findById(id);
    }

    public void deleteById(int id) {
        participantRepository.deleteById(id);
    }


    public Participant patchById(int id, Participant updateParticipant) {
        Participant participant = findById(id);
        participant.setFirstName(updateParticipant.getFirstName());
        participant.setLastName(updateParticipant.getLastName());
        return participantRepository.save(participant);
    }


    public Participant createParticipant(Participant createParticipantRequest) {
        return participantRepository.save(createParticipantRequest);
    }
}
