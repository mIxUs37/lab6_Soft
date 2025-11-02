package com.example.lab6.lab6.Repository;

import com.example.lab6.lab6.model.Operators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorsRepository extends JpaRepository<Operators, Long> {
}
