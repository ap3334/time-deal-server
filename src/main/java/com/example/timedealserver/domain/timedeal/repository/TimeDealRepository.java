package com.example.timedealserver.domain.timedeal.repository;

import com.example.timedealserver.domain.timedeal.entity.TimeDeal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeDealRepository extends JpaRepository<TimeDeal, Long> {
}
