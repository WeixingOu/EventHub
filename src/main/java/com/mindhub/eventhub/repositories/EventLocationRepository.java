package com.mindhub.eventhub.repositories;

import com.mindhub.eventhub.models.EventLocation;
import com.mindhub.eventhub.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EventLocationRepository extends JpaRepository<EventLocation, UUID> {
    Optional<EventLocation> findByLocationLocationIdAndEventDate(UUID locationId, LocalDate localDate);
}
