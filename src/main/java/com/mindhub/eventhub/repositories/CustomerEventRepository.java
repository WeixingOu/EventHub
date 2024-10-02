package com.mindhub.eventhub.repositories;

import com.mindhub.eventhub.models.CustomerEvent;
import com.mindhub.eventhub.models.Event;
import com.mindhub.eventhub.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerEventRepository extends JpaRepository<CustomerEvent, UUID> {
    Optional<CustomerEvent> findByEventAndParticipant(Event event, Participant participant);
    List<CustomerEvent> findByParticipant(Participant participant);
}
