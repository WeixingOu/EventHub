package com.mindhub.eventhub.repositories;

import com.mindhub.eventhub.models.CustomerEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerEventRepository extends JpaRepository<CustomerEvent, UUID> {
}
