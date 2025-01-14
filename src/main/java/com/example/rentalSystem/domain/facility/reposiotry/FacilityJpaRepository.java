package com.example.rentalSystem.domain.facility.reposiotry;

import com.example.rentalSystem.domain.facility.entity.Facility;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityJpaRepository extends JpaRepository<Facility, Long> {

  Optional<Facility> findByNameAndLocation(String name, String location);
}
