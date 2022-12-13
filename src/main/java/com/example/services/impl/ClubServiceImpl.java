package com.example.services.impl;

import com.example.dto.ClubDTO;
import com.example.model.Club;
import com.example.repository.ClubRepository;
import com.example.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDTO> findAllClub() {
        List<Club> clubs=clubRepository.findAll();
        return clubs.stream().map(club -> mapToClubDTO(club)).collect(Collectors.toList());
    }

    private ClubDTO mapToClubDTO(Club club) {
        ClubDTO clubDTO=ClubDTO.builder()
                .mId(club.getMId())
                .updatedOn(club.getUpdatedOn())
                .firstName(club.getFirstName())
                .lastName(club.getLastName())
                .createdOn(club.getCreatedOn())
                .email(club.getEmail())
                .build();
        return clubDTO;
    }
}
