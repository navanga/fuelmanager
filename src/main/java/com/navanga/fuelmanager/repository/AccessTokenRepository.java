package com.navanga.fuelmanager.repository;

import com.navanga.fuelmanager.domain.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessTokenRepository extends JpaRepository<AccessToken, Long> {

}
