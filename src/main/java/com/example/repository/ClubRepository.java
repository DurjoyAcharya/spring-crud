package com.example.repository;

import com.example.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club,Integer> {
    Optional<Club> findClubByAddress(String email);
}
