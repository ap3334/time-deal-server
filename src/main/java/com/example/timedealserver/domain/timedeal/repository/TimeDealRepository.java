package com.example.timedealserver.domain.timedeal.repository;

import com.example.timedealserver.domain.timedeal.entity.TimeDeal;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;
import java.util.Optional;

public interface TimeDealRepository extends JpaRepository<TimeDeal, Long> {
    List<TimeDeal> findByProductId(Long productId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<TimeDeal> findById(Long timeDealId);

}
