package com.mindhub.eventhub.repositories;

import com.mindhub.eventhub.models.CustomerEvent;
import com.mindhub.eventhub.models.EventAttend;
import com.mindhub.eventhub.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventAttendRepository extends JpaRepository<EventAttend, Long> {
    List<EventAttend> findByCustomerEvent(CustomerEvent customerEvent);
}
