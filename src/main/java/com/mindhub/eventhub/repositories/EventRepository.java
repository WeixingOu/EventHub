package com.mindhub.eventhub.repositories;

import com.mindhub.eventhub.models.Event;
import com.mindhub.eventhub.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
    List<Event> findByActiveTrue();
    List<Event> findByManager(Manager manager);
}
