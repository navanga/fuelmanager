package com.navanga.fuelmanager.repository;

import com.navanga.fuelmanager.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
}
