package com.example.lab6.lab6.Repository;

import com.example.lab6.lab6.model.ApplicationRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRequestsRepository extends JpaRepository<ApplicationRequests, Long> {
}
